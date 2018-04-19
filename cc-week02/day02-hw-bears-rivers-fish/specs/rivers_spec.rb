require("minitest/autorun")
require_relative("../rivers")
require_relative("../fish")

class RiverTest < MiniTest::Test
  def setup
    fish1 = Fish.new("fish1")
    fish2 = Fish.new("fish2")
    fish3 = Fish.new("fish3")
    fish4 = Fish.new("fish4")
    @fishes =[fish1, fish2, fish3, fish4]
    @river = River.new("Amazon",@fishes)
  end

  def test_river_has_name
    name = @river.name()
    assert_equal("Amazon", name)
  end

  def test_river_has_fish
    fish_array = @river.get_fish()
    assert_equal(@fishes, fish_array)
  end

  def test_number_fish_in_river
    number_of_fish = @river.number_of_fish()
    assert_equal(4, number_of_fish)
  end
  # Fish count method

end
