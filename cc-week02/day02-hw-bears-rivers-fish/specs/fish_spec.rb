require("minitest/autorun")
require_relative("../fish")

class FishTest < MiniTest::Test
  def setup
    @fish = Fish.new("Fishy1")
  end

  def test_fish_has_name
    name = @fish.name()
    assert_equal("Fishy1", name)
  end
end
