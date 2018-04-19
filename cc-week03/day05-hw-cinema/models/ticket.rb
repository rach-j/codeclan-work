require_relative('customer.rb')
require_relative('film.rb')
require_relative('screening.rb')
require_relative('../db/sql_runner.rb')

class Ticket

  attr_reader :id
  attr_accessor :customer_id, :screening_id

  def initialize(inputs)
    @id = inputs['id'].to_i() if inputs['id']
    @customer_id = inputs['customer_id']
    @screening_id = inputs['screening_id']
  end

  def save()
    sql = "INSERT INTO tickets
    (
      customer_id, screening_id
    )
    VALUES
    (
      $1, $2
    )
    RETURNING *;"
    ticket = SqlRunner.run(sql, [@customer_id, @screening_id]).first()
    @id = ticket['id'].to_i()
  end

  def update()
    sql = "UPDATE tickets
    SET
    (
      customer_id, screening_id
    )
    =
    (
      $1, $2
    )
    WHERE id = $3;"
    SqlRunner.run(sql, [@customer_id, @screening_id, @id])
  end

  def delete()
    sql = "DELETE FROM tickets
    WHERE id = $1"
    SqlRunner.run(sql, [@id])
  end

  def Ticket.delete_all()
    sql = "DELETE FROM tickets"
    SqlRunner.run(sql)
  end

  def Ticket.all()
    sql = "SELECT * FROM tickets"
    tickets = SqlRunner.run(sql)
    return tickets.map {|ticket| Ticket.new(ticket)}
  end
end
