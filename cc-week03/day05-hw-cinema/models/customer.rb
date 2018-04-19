require_relative('../db/sql_runner.rb')
require_relative('film.rb')
require_relative('ticket.rb')
require_relative('screening.rb')

class Customer

  attr_reader :id
  attr_accessor :name, :funds

  def initialize(inputs)
    @id = inputs['id'].to_i() if inputs['id']
    @name = inputs['name']
    @funds = inputs['funds'].to_f()
  end

  def save()
    sql = "INSERT INTO customers
    (
      name, funds
    )
    VALUES
    (
      $1, $2
    )
    RETURNING *;"
    customer = SqlRunner.run(sql, [@name, @funds]).first()
    @id = customer['id'].to_i()
  end

  def update()
    sql = "UPDATE customers
    SET
    (
      name, funds
    )
    =
    (
      $1, $2
    )
    WHERE id = $3;"
    SqlRunner.run(sql, [@name, @funds, @id])
  end

  def delete()
    sql = "DELETE FROM customers
    WHERE id = $1"
    SqlRunner.run(sql, [@id])
  end

  def films_booked()
    sql = "SELECT screenings.* FROM screenings
    INNER JOIN tickets
    ON tickets.screening_id = screenings.id
    WHERE customer_id = $1;"
    films_booked = SqlRunner.run(sql, [@id])
    output = films_booked.map do |film|
      film_found = Film.find_by_id(Screening.new(film).film_id)
      film_title = film_found.title
      film_time = Screening.new(film).show_time
      "#{film_title} at #{film_time}"
    end
    return output
  end


  def buy_ticket(screening)
    return "This show is fully booked already!" if screening.number_of_viewers() >= 5
    id_for_film = screening.film_id
    film = Film.find_by_id(id_for_film)
    film_price = film.price
    @funds -=film_price
    update()
    ticket = Ticket.new({'customer_id' => id(), 'screening_id' => screening.id()})
    ticket.save()
    return "Ticket has been purchased!"
  end
  # Method does not check to see if customer has sufficient funds, but does
  # limit available tickets for screening

  def how_many_tickets()
    return films_booked.length()
  end

  def Customer.delete_all()
    sql = "DELETE FROM customers"
    SqlRunner.run(sql)
  end

  def Customer.all()
    sql = "SELECT * FROM customers"
    customers = SqlRunner.run(sql)
    return customers.map {|customer| Customer.new(customer)}
  end
end
