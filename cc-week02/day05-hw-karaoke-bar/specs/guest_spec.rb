require('minitest/autorun')
require_relative('../guest')
require_relative('../song')
require_relative('../drink')

class TestGuest < MiniTest::Test
  def setup

    @drink1 = Drink.new("Diet Coke", 2.5)
    @drink2 = Drink.new("Bruichladdich 30", 75)

    song1 = Song.new("Dancing in the Moonlight")
    song2 = Song.new("Feeling Good")
    @playlist1 = [song1, song2]
    @playlist2 = [song2]
    @song1 = song1

    @guest1 = Guest.new("Rachel", 25, song1)
  end

  def test_guest_name
    name = @guest1.guest_name()
    assert_equal("Rachel", name)
  end

  def test_money
    money = @guest1.money()
    assert_equal(25, money)
  end

  def test_favourite_song
    favourite_song = @guest1.favourite_song()
    assert_equal(@song1, favourite_song)
  end

  def test_member_pays__member_can_afford
    @guest1.member_pays(15)
    new_money = @guest1.money()
    assert_equal(10, new_money)
  end

  def test_member_pays__member_cannot_afford
    @guest1.member_pays(35)
    new_money = @guest1.money()
    assert_equal(0, new_money)
  end

  def test_favourite_song_on_playlist__song_is_there
    result = @guest1.favourite_song_on_playlist(@playlist1)
    assert_equal("Woohoo!", result)
  end

  def test_favourite_song_on_playlist__song_is_not_there
    result = @guest1.favourite_song_on_playlist(@playlist2)
    assert_nil(result)
  end

  def test_buy_drink__has_enough_money
    @guest1.buy_drink(@drink1)
    new_money = @guest1.money()
    assert_equal(22.5, new_money)
  end

  def test_buy_drink__does_not_have_enough_money
    @guest1.buy_drink(@drink2)
    new_money = @guest1.money()
    assert_equal(25, new_money)
  end
end
