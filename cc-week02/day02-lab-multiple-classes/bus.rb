require_relative('person')
require_relative('bus_stop')

class Bus

  attr_reader(:route_number, :destination)

  def initialize(route_number, destination)
    @route_number = route_number
    @destination = destination
    @passengers = []
  end

  def drive()
    return "Brum, brum"
  end

  def number_passengers()
    @passengers.length
  end

  def bus_pickup(person)
    @passengers.push(person)
  end

  def bus_dropoff(person)
   @passengers.delete(person)
   return @passengers
  end

  def empty()
    @passengers.clear()
  end

  def pick_up_from_stop(name_of_stop)
    queue_at_stop = name_of_stop.queue
    @passengers + queue_at_stop
  end
end
