class BusStop

attr_reader :queue

  def initialize (name_of_stop)
    @name_of_stop = name_of_stop
    @queue = []
  end

  def add_to_queue(person)
    @queue.push(person)
  end

end
