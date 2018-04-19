require_relative('../db/sql_runner.rb')
# require_relative('customer.rb')
# require_relative('ticket.rb')


class Film

  attr_reader :id
  attr_accessor :title, :price

  def initialize(inputs)
    @id = inputs['id'].to_i() if inputs['id']
    @title = inputs['title']
    @price = inputs['price'].to_f()
  end

  def save()
    sql = "INSERT INTO films
    (
      title, price
    )
    VALUES
    (
      $1, $2
    )
    RETURNING *;"
    film = SqlRunner.run(sql, [@title, @price]).first()
    @id = film['id'].to_i()
  end

  def update()
    sql = "UPDATE films
    SET
    (
      title, price
    )
    =
    (
      $1, $2
    )
    WHERE id = $3;"
    SqlRunner.run(sql, [@title, @price, @id])
  end

  def delete()
    sql = "DELETE FROM films
    WHERE id = $1;"
    SqlRunner.run(sql, [@id])
  end

  def screening_ids()
    sql = "SELECT id FROM screenings
    WHERE film_id = $1;"
    screening_ids = SqlRunner.run(sql, [@id])
    screening_ids_array = screening_ids.map {|screening_id| screening_id['id'].to_i()}
    return screening_ids_array
  end
  # Returns array of all screening ids for a particular film

  def most_popular_time()
    screening_ids_array = screening_ids()
    ticket_hash = {}
    most_popular_times = []
    screening_ids_array.each do |id|
      sql = "SELECT screening_id FROM tickets
      WHERE screening_id = $1;"
      result = SqlRunner.run(sql, [id])
      ticket_hash[id] = result.map {|ticket| ticket}.length
    end
# Creates a hash with keys for each screening id for the film in question. Each
# key has a corresponding value equal to the number of tickets sold for that
# screening. Could be done with inner joins?
    max_number_views = ticket_hash.values.max()
    most_popular_screening_id = ticket_hash.map {|key, _| key if ticket_hash[key] == max_number_views}.compact()
# Haven't used .key here as that wouldn't return all screenings where several
# show times have the same highest number of tickets sold
    most_popular_screening_id.each do |screening_id|
      sql = "SELECT show_time FROM screenings
      WHERE id = $1;"
      most_popular = SqlRunner.run(sql, [screening_id])
      most_popular_times.push(most_popular.map {|id| id['show_time']}[0])
    end
    return most_popular_times
  end

  # def customers_viewing()
  #   sql = "SELECT customers.* FROM customers
  #   INNER JOIN tickets
  #   ON tickets.customer_id = customers.id
  #   WHERE film_id = $1;"
  #   customers_viewing = SqlRunner.run(sql, [@id])
  #   return customers_viewing.map {|customer| Customer.new(customer)}
  # end

  # def number_of_viewers()
  #   customers_viewing.length()
  # end

  def Film.find_by_id(id)
    sql = "SELECT * FROM films
    WHERE id = $1;"
    film_found = SqlRunner.run(sql, [id]).first
    return Film.new(film_found)
  end

  def Film.delete_all()
    sql = "DELETE FROM films;"
    SqlRunner.run(sql)
  end

  def Film.all()
    sql = "SELECT * FROM films;"
    films = SqlRunner.run(sql)
    return films.map {|film| Film.new(film)}
  end

end
