require('minitest/autorun')
require_relative('../room')
require_relative('../guest')
require_relative('../song')
require_relative('../bar')
require_relative('../drink')

class TestRoom < MiniTest::Test
  def setup

    @bar1 = Bar.new("Bar1")

    @drink1 = Drink.new("Diet Coke", 2.5)

    @song1 = Song.new("Dancing in the Moonlight")
    @song2 = Song.new("Creep")
    @song3 = Song.new("Ring of Fire")
    @song4 = Song.new("Mambo Number 5")
    @song5 = Song.new("Killing Me Softly")

    @guest1 = Guest.new("Rachel", 25, @song1)
    guest2 = Guest.new("Sarah", 35, @song2)
    @guest3 = Guest.new("Fern", 10, @song5)
    @guest4 = Guest.new("Nicki", 15, @song4)
    guest5 = Guest.new("Jen", 20, @song5)
    guest6 = Guest.new("Jena", 25, @song1)
    guest7 = Guest.new("Harriet", 30, @song2)
    guest8 = Guest.new("Louise", 15, @song3)
    guest9 = Guest.new("Becca", 20, @song4)
    guest10 = Guest.new("Skelly", 0, @song5)

    @guest_group1 = [@guest1, guest2, @guest3]
    # Can afford karaoke collectively but 1 individual can't afford cost split
    # evenly between the group
    @guest_group2 = [@guest4, guest5, guest6, guest7, guest8, guest9]
    #  Each member can afford their share of karaoke
    #  Group too big for the room
    @guest_group3 = [guest2, @guest3]
    # Can't afford karaoke
    @guest_group4 = [@guest1, guest2, guest10]
    # 1 member has no money

    @playlist1 = [@song1, @song2, @song3, @song4]

    @room1 = Room.new("Room 1", 5, @playlist1, 50, @bar1)
  end

  def test_room_name
    room_name = @room1.room_name()
    assert_equal("Room 1", room_name)
  end

  def test_room_capacity
    room_capacity = @room1.room_capacity()
    assert_equal(5, room_capacity)
  end

  def test_current_guests
    current_guests = @room1.current_guests()
    assert_equal([],current_guests)
  end

  def test_playlist
    playlist_in_room = @room1.playlist()
    assert_equal(@playlist1, playlist_in_room)
  end

  def test_room_cost
    room_cost = @room1.room_cost()
    assert_equal(50, room_cost)
  end

  def test_bar
    attaching_bar = @room1.bar()
    assert_equal(@bar1, attaching_bar)
  end

  def test_takings
    takings = @room1.takings()
    assert_equal(0,takings)
  end

  def test_return_wohoos
    result = @room1.return_wohoos(@guest_group1)
    assert_equal(["Woohoo!","Woohoo!"], result)
  end

  def test_enough_money_to_sing__has_enough_money
    result = @room1.enough_money_to_sing?(@guest_group1)
    assert_equal(true, result)
  end

  def test_enough_money_to_sing__not_enough_money
    result = @room1.enough_money_to_sing?(@guest_group3)
    assert_equal(false, result)
  end

  def test_guests_with_money__all_have_money
    number_with_money = @room1.guests_with_money(@guest_group1)
    assert_equal(3, number_with_money)
  end

  def test_guests_with_money__not_all_have_money
    number_with_money = @room1.guests_with_money(@guest_group4)
    assert_equal(2, number_with_money)
  end

  def test_spread_out_costs__all_have_enough_money
    @room1.spread_out_costs(@guest_group2)
    guest4_money = @guest4.money().round(3)
    assert_equal(6.667, guest4_money)
  end

  def test_spread_out_costs__not_all_have_enough_money
    @room1.spread_out_costs(@guest_group1)
    guest1_money = @guest1.money().round(3)
    guest3_money = @guest3.money()
    assert_equal(5.000, guest1_money)
    assert_equal(0.000, guest3_money)
  end

  def test_check_in_guests__room_empty
    result = @room1.check_in_guests(@guest_group1)
    guests_in_room = @room1.current_guests()
    guest1_money = @guest1.money().round(3)
    takings = @room1.takings()
    assert_equal(@guest_group1, guests_in_room)
    assert_equal(5.000, guest1_money)
    assert_equal(["Woohoo!", "Woohoo!"], result)
    assert_equal(50, takings)
  end
  # Not sure if all asserts needed? Know the functions within this function work
  # but need to check it's being called correctly?

  def test_check_in_guests__room_has_guests
    result1 = @room1.check_in_guests(@guest_group1)
    result2 = @room1.check_in_guests(@guest_group2)
    guests_in_room = @room1.current_guests()
    guest1_money = @guest1.money().round(3)
    guest4_money = @guest4.money().round(3)
    takings = @room1.takings()
    assert_equal(@guest_group1, guests_in_room)
    assert_equal(5.000, guest1_money)
    assert_equal(15.000, guest4_money)
    assert_equal(["Woohoo!", "Woohoo!"], result1)
    assert_nil(result2)
    assert_equal(50, takings)
  end
   # Not sure if all asserts needed? Know the functions within this function work
   # but need to check it's being called correctly?

  def test_check_in_guests__more_guests_than_room_capacity
    result = @room1.check_in_guests(@guest_group2)
    guests_in_room = @room1.current_guests()
    takings = @room1.takings()
    assert_equal([],guests_in_room)
    assert_nil(result)
    assert_equal(0, takings)
  end
  # Not sure if all asserts needed? Know the functions within this function work
  # but need to check it's being called correctly?

  def test_check_in_guests__guests_cannot_afford
    result = @room1.check_in_guests(@guest_group3)
    guests_in_room = @room1.current_guests()
    guest4_money = @guest4.money()
    takings = @room1.takings()
    assert_equal([],guests_in_room)
    assert_nil(result)
    assert_equal(15,guest4_money)
    assert_equal(0, takings)
  end
  # Not sure if all asserts needed? Know the functions within this function work
  # but need to check it's being called correctly?

  def test_check_out_guests__guests_are_in_room
    @room1.check_in_guests(@guest_group1)
    @room1.check_out_guests(@guest_group1)
    guests_in_room = @room1.current_guests()
    assert_equal([],guests_in_room)
  end

  def test_check_out_guests__guests_are_not_in_room
    result = @room1.check_out_guests(@guest_group1)
    guests_in_room = @room1.current_guests()
    assert_equal([],guests_in_room)
    assert_nil(result)
  end

  def test_check_out_guests__different_guests_are_in_room
    @room1.check_in_guests(@guest_group1)
    result = @room1.check_out_guests(@guest_group2)
    guests_in_room = @room1.current_guests()
    assert_equal(@guest_group1,guests_in_room)
    assert_nil(result)
  end

  def test_add_song_to_room__song_not_already_there
    @room1.add_song(@song5)
    new_playlist = @room1.playlist()
    expected_playlist = [@song1, @song2 , @song3, @song4, @song5]
    assert_equal(expected_playlist,new_playlist)
  end

  def test_add_song_to_room__song_already_there
    @room1.add_song(@song1)
    new_playlist = @room1.playlist()
    expected_playlist = [@song1, @song2 , @song3, @song4]
    assert_equal(expected_playlist, new_playlist)
  end

  def test_takings_from_bar_and_room__no_drink_sales
    @room1.check_in_guests(@guest_group1)
    total_takings = @room1.takings_from_bar_and_room()
    assert_equal(50, total_takings)
  end

  def test_takings_from_bar_and_room__drink_sales
    @room1.check_in_guests(@guest_group1)
    @bar1.sell_drink(@guest1, @drink1)
    total_takings = @room1.takings_from_bar_and_room()
    assert_equal(52.5, total_takings)
  end

end
