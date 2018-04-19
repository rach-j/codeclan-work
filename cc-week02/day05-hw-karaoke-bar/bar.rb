class Bar
  attr_reader :bar_name, :bar_tab
  def initialize(bar_name)
    @bar_name = bar_name
    @bar_tab = 0
  end

  def sell_drink(guest, drink)
    return if guest.money() < drink.price()
    guest.buy_drink(drink)
    @bar_tab += drink.price()  
  end
end
