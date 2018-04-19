class Guest
attr_reader :guest_name, :money, :favourite_song

  def initialize (guest_name, money, favourite_song)
    @guest_name = guest_name
    @money = money
    @favourite_song = favourite_song
  end

  def member_pays(entry_fee)
    if entry_fee > @money
      @money = 0
    else
      @money -= entry_fee
    end
  end
  # Function set up so that a guest pays all their money if they cannot afford
  # the entry fee. This enables the functionality in the room class for groups
  # to pay for karaoke provided their pooled money exceeds the cost of the
  # karaoke regardless of whether the price split evenly exceeds the amount of
  # money an individual has.



  def favourite_song_on_playlist(playlist)
    return "Woohoo!" if playlist.include?(@favourite_song)
  end

  def buy_drink(drink)
    @money -=drink.price() if @money >= drink.price()
  end
end
