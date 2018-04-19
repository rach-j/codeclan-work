require_relative('../db/sql_runner.rb')
require_relative('customer.rb')
require_relative('ticket.rb')

class Screening

  attr_reader :id
  attr_accessor :show_time, :film_id

  def initialize(inputs)
    @id = inputs['id'].to_i() if inputs['id']
    @show_time = inputs['show_time']
    @film_id = inputs['film_id']
  end

  def save()
    sql = "INSERT INTO screenings
    (
      show_time, film_id
    )
    VALUES
    (
      $1, $2
    )
    RETURNING *;"
    show_time = SqlRunner.run(sql, [@show_time, @film_id]).first()
    @id = show_time['id'].to_i()
  end

  def update()
    sql = "UPDATE screenings
    SET
    (
      show_time, film_id
    )
    =
    (
      $1, $2
    )
    WHERE id = $3;"
    SqlRunner.run(sql, [@show_time, @film_id, @id])
  end

  def delete()
    sql = "DELETE FROM screenings
    WHERE id = $1;"
    SqlRunner.run(sql, [@id])
  end

  def customers_viewing()
    sql = "SELECT customers.* FROM customers
    INNER JOIN tickets
    ON tickets.customer_id = customers.id
    WHERE screening_id = $1;"
    customers_viewing = SqlRunner.run(sql, [@id])
    return customers_viewing.map {|customer| Customer.new(customer)}
  end

  def number_of_viewers()
    customers_viewing.length()
  end

  def Screening.all()
    sql = "SELECT * FROM screenings;"
    screenings = SqlRunner.run(sql)
    return screenings.map {|screening| Screening.new(screening)}
  end


  def Screening.delete_all()
    sql = "DELETE FROM screenings"
    SqlRunner.run(sql)
  end

end
