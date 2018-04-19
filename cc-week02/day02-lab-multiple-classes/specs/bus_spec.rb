require('minitest/autorun')
require_relative('../bus')
require_relative('../person')
require_relative('../bus_stop')

class BusTest < MiniTest::Test
  def setup
    @bus = Bus.new(22, "Ocean Terminal")
    @stop1 = BusStop.new("Lothian Road")
    paul = Person.new("Paul", 52)
    verity = Person.new("Verity", 29)
    rachel = Person.new("Rachel", 29)
    @stop1.add_to_queue(verity)
    @stop1.add_to_queue(paul)
    @stop1.add_to_queue(rachel)
  end

  def test_returns_sound
    sound = @bus.drive()
    assert_equal("Brum, brum", sound)
  end

  def test_how_many_passengers
    number_passengers = @bus.number_passengers()
    assert_equal(0,number_passengers)
  end

  def test_bus_pickup
    rachel = Person.new("Rachel",29)
    people_on_bus = @bus.bus_pickup(rachel)
    assert_equal([rachel],people_on_bus)
  end

  def test_bus_dropoff__person_in_bus
    rachel = Person.new("Rachel",29)
    @bus.bus_pickup(rachel)
    people_on_bus = @bus.bus_dropoff(rachel)
    assert_equal([], people_on_bus)
  end

  # def test_bus_dropoff__person_not_in_bus
  #   oli = Person.new("Oli", 33)
  #   people_on_bus = @bus.bus_dropoff(oli)
  #   assert_equal("Person not on bus", people_on_bus)
  # end

  def test_empty
    rachel = Person.new("Rachel",29)
    oli = Person.new("Oli", 33)
    @bus.bus_pickup(rachel)
    @bus.bus_pickup(oli)
    empty_bus = @bus.empty()
    assert_equal([], empty_bus)
  end

  def test_pick_up_from_stop
    @bus.pick_up_from_stop(@stop1)
    count = @bus.number_passengers
    assert_equal(3, count)
    # assert_equal(0, @stop1.number_passengers())
  end

end
