require('minitest/autorun')
require_relative('../drink')

class TestDrink < MiniTest::Test
  def setup
    @drink1 = Drink.new("Diet Coke", 2.50)
  end

  def test_drink_name
    name = @drink1.drink_name()
    assert_equal("Diet Coke", name)
  end

  def test_price
    price = @drink1.price()
    assert_equal(2.50, price)
  end
end
