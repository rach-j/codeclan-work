class Room

  attr_reader :room_name, :room_capacity, :current_guests, :playlist, :room_cost, :bar, :takings

  def initialize(room_name, room_capacity, playlist, room_cost, bar)
    @room_name = room_name
    @room_capacity = room_capacity
    @current_guests = []
    @playlist = playlist
    @room_cost = room_cost
    @bar = bar
    @takings = 0
  end

def enough_money_to_sing?(guest_array)
  total = 0
  for guest in guest_array
    total += guest.money()
  end
  return total >=@room_cost
end

def guests_with_money(guest_array)
  guests_with_money = 0
  for guest in guest_array
    guests_with_money +=1  if guest.money() > 0
  end
  return guests_with_money
end

def spread_out_costs(guest_array)
  outstanding_cost = @room_cost
  total_paid = 0
  number_with_money = guests_with_money(guest_array)
  while outstanding_cost > 0
    entry_fee_for_each = outstanding_cost.to_f()/number_with_money
    for guest in guest_array
      starting_value_in_wallet = guest.money()
      guest.member_pays(entry_fee_for_each)
      total_paid += [starting_value_in_wallet,entry_fee_for_each].min
    end
    outstanding_cost -= total_paid
    number_with_money = guests_with_money(guest_array)
  end
end

def return_wohoos(guest_array)
  woohoos = []
  for guest in guest_array
    if guest.favourite_song_on_playlist(@playlist) == "Woohoo!"
      woohoos.push(guest.favourite_song_on_playlist(@playlist))
    end
  end
  return woohoos
end

  def check_in_guests(guest_array)
    return nil if @current_guests != []
    return nil if guest_array.length() > @room_capacity
    return nil if !enough_money_to_sing?(guest_array)
    @current_guests += guest_array
    spread_out_costs(guest_array)
    @takings += @room_cost
    return_wohoos(guest_array)
  end

  def check_out_guests(guest_array)
    return nil if @current_guests != guest_array
    @current_guests -= guest_array
  end

  def add_song(new_song)
    return if @playlist.include?(new_song)
    @playlist.push(new_song)
  end

  def takings_from_bar_and_room()
    total_takings = @takings + @bar.bar_tab()
    return total_takings
  end

end
