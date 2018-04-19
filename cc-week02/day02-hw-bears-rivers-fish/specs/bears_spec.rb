require("minitest/autorun")
require_relative("../bears")
require_relative("../rivers")
require_relative("../fish")

class BearTest < MiniTest::Test
  def setup
    @bear = Bear.new("Yogi")
    fish1 = Fish.new("fish1")
    fish2 = Fish.new("fish2")
    fish3 = Fish.new("fish3")
    fish4 = Fish.new("fish4")
    fishes =[fish1, fish2, fish3, fish4]
    @river = River.new("Amazon", fishes)
  end

  def test_bear_has_name
    name = @bear.name()
    assert_equal("Yogi", name)
  end

  def test_bear_has_stomach_contents
    stomach_contents = @bear.stomach_contents()
    assert_equal([], stomach_contents)
  end

  def test_amount_in_stomach
    amount_in_stomach = @bear.amount_in_stomach()
    assert_equal(0, amount_in_stomach)
  end
  # Food count method

  def test_bear_takes_fish_from_river__initial
    @bear.take_fish_from_river(@river)
    assert_equal(1, @bear.amount_in_stomach)
    assert_equal(3, @river.number_of_fish)
  end

  def test_bear_takes_fish_from_river__another_fish
    @bear.take_fish_from_river(@river)
    @bear.take_fish_from_river(@river)
    assert_equal(2, @bear.amount_in_stomach)
    assert_equal(2, @river.number_of_fish)
  end

  def test_bear_roars
    bear_noise = @bear.roar()
    assert_equal("RROOOAAARR!!!", bear_noise)
  end
end
