require('minitest/autorun')
require_relative('../bar')
require_relative('../drink')
require_relative('../guest')
require_relative('../song')

class TestBar < MiniTest::Test
  def setup
    @bar1 = Bar.new("Bar1")

    @drink1 = Drink.new("Diet Coke", 2.5)
    @drink2 = Drink.new("Bruichladdich 30", 75)

    song1 = Song.new("Dancing in the Moonlight")
    @guest1 = Guest.new("Rachel", 25, song1)
  end

  def test_bar_name
    name = @bar1.bar_name()
    assert_equal("Bar1", name)
   end

   def test_bar_tab
     bar_tab = @bar1.bar_tab()
     assert_equal(0, bar_tab)
   end

   def test_sell_drink__guest_has_enough_money
     @bar1.sell_drink(@guest1, @drink1)
     new_money = @guest1.money()
     new_bar_tab = @bar1.bar_tab()
     assert_equal(22.5, new_money)
     assert_equal(2.5, new_bar_tab)
   end

   def test_sell_drink__guest_does_not_have_enough_money
     @bar1.sell_drink(@guest1, @drink2)
     new_money = @guest1.money()
     new_bar_tab = @bar1.bar_tab()
     assert_equal(25, new_money)
     assert_equal(0, new_bar_tab)
   end
end
