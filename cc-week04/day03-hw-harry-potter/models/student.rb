require_relative('../db/sql_runner')
require_relative('./house.rb')

class Student

  attr_reader :first_name, :last_name, :house_id, :age, :id

  def initialize(inputs)
    @id = inputs['id'].to_i() if inputs['id']
    @first_name = inputs['first_name']
    @last_name = inputs['last_name']
    @house_id = inputs['house_id']
    @age = inputs['age'].to_i()
  end

  def nice_name()
    return "#{first_name} #{last_name}"
  end

  def save()
    sql = "INSERT INTO students
    (
      first_name,
      last_name,
      house_id,
      age
    )
    VALUES
    (
      $1, $2, $3, $4
    )
    RETURNING *;"
    values = [@first_name, @last_name, @house_id, @age]
    student_data = SqlRunner.run(sql, values)
    @id = student_data.first()['id'].to_i()
  end

  def update()
    sql = "UPDATE students
    SET (
      first_name,
      last_name,
      house_id,
      age
      )=
      (
        $1, $2, $3, $4
      )
      WHERE id = $5;"
      values =[@first_name, @last_name, @house_id, @age, @id]
      SqlRunner.run(sql, values)
    end

    def house()
      sql = "SELECT houses.* FROM houses
      INNER JOIN students ON
      houses.id = students.house_id
      WHERE students.id = $1;"
      values = [@id]
      house = SqlRunner.run(sql, values)
      result = House.new(house.first())
      return result.name()
    end

    def Student.delete_all()
        sql = "DELETE FROM students;"
        SqlRunner.run(sql)
    end

    def delete()
      sql = "DELETE FROM students
      WHERE id = $1;"
      values = [@id]
      SqlRunner.run(sql, values)
    end

    def Student.all()
      sql = "SELECT * FROM students;"
      students = SqlRunner.run(sql)
      result = students.map {|student| Student.new(student)}
      return result
    end

    def Student.find(id)
      sql = "SELECT * FROM students
      WHERE id = $1;"
      values = [id]
      student = SqlRunner.run(sql, values)
      result = Student.new(student.first())
      return result
    end

  end
