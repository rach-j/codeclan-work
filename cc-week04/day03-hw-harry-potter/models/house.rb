require_relative('../db/sql_runner.rb')

class House

  attr_reader :name, :url, :id

  def initialize(inputs)
    @id = inputs['id'].to_i() if inputs['id']
    @name = inputs['name']
    @url = inputs['url']
  end

  def save()
    sql = "INSERT INTO houses
    (
      name, url
    )
    VALUES
    (
      $1, $2
    )
    RETURNING *;"
    values = [@name, @url]
    house_data = SqlRunner.run(sql, values)
    @id = house_data.first()['id'].to_i()
  end

  def House.delete_all()
    sql = "DELETE FROM houses;"
    SqlRunner.run(sql)
  end

  def House.all()
    sql = "SELECT * FROM houses;"
    houses = SqlRunner.run(sql)
    result = houses.map {|house| House.new(house)}
    return result
  end

  def House.find(id)
    sql = "SELECT * FROM houses
    WHERE id = $1;"
    values = [@id]
    house = SqlRunner.run(sql, values)
    result = House.new(house.first())
    return result
  end
end
