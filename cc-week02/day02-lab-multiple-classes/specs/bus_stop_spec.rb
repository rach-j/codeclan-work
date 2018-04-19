require ("minitest/autorun")
require_relative("../bus_stop")
require_relative("../bus")
require_relative('../person')

class BusStopTest < MiniTest::Test
  def setup
    @busstop = BusStop.new("Lothian Road")
  end

  def test_add_to_queue
    rachel = Person.new("Rachel",29)
    new_queue = @busstop.add_to_queue(rachel)
    assert_equal([rachel], new_queue)
  end

end
