require('pry-byebug')
require_relative('models/customer.rb')
require_relative('models/film.rb')
require_relative('models/screening.rb')
require_relative('models/ticket.rb')
require_relative('db/sql_runner.rb')
require_relative('models/time_table.rb')

Ticket.delete_all()
Customer.delete_all()
Screening.delete_all()
Film.delete_all()

customer1 = Customer.new({'name' => 'Rachel', 'funds' => 100.50})
customer2 = Customer.new({'name' => 'Grace', 'funds' => 75})
customer3 = Customer.new({'name' => 'Max', 'funds' => 150.75})
customer4 = Customer.new({'name' => 'Ben', 'funds' => 99})

customer1.save()
customer2.save()
customer3.save()
customer4.save()

# customer1.name = "Sara"
# customer1.update()

film1 = Film.new({
  'title' => 'Bladerunner',
  'price' => 10.50})
film2 = Film.new({
  'title' => 'Vanilla Sky',
  'price' => 8.50})
film3 = Film.new({
  'title' => 'Moonrise Kingdom',
  'price' => 9.50})
film4 = Film.new({
  'title' => 'Her',
  'price' => 11})

film1.save()
film2.save()
film3.save()
film4.save()

# film1.title = "Mad Max"
# film1.update()

screening1 = Screening.new({'show_time' => "13:30", 'film_id' => film1.id})
screening2 = Screening.new({'show_time' => "16:30", 'film_id' => film2.id} )
screening3 = Screening.new({'show_time' => "17:45", 'film_id' => film2.id})
screening4 = Screening.new({'show_time' => "19:30", 'film_id' => film1.id})
screening5 = Screening.new({'show_time' => "21:00", 'film_id' => film3.id})
screening6 = Screening.new({'show_time' => "23:15", 'film_id' => film4.id})

screening1.save()
screening2.save()
screening3.save()
screening4.save()
screening5.save()
screening6.save()

ticket1 = Ticket.new({'customer_id' => customer1.id(), 'screening_id' => screening1.id()})
ticket2 = Ticket.new({'customer_id' => customer1.id(), 'screening_id' => screening2.id()})
ticket3 = Ticket.new({'customer_id' => customer1.id(), 'screening_id' => screening3.id()})
ticket4 = Ticket.new({'customer_id' => customer1.id(), 'screening_id' => screening4.id()})
ticket5 = Ticket.new({'customer_id' => customer1.id(), 'screening_id' => screening5.id()})
ticket6 = Ticket.new({'customer_id' => customer2.id(), 'screening_id' => screening6.id()})
ticket7 = Ticket.new({'customer_id' => customer3.id(), 'screening_id' => screening1.id()})
ticket8 = Ticket.new({'customer_id' => customer4.id(), 'screening_id' => screening2.id()})

ticket1.save()
ticket2.save()
ticket3.save()
ticket4.save()
ticket5.save()
ticket6.save()
ticket7.save()
ticket8.save()

# customer3.buy_ticket(screening4.id)

binding.pry

nil
