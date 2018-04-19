

class Bear
  attr_reader :name, :stomach_contents

  def initialize(name)
    @name = name
    @stomach_contents = []
  end

  def amount_in_stomach()
    return @stomach_contents.length
  end
    # Food count method

  def take_fish_from_river(river)
    fish_array = river.get_fish()
    fish_taken = fish_array.pop()
    @stomach_contents.push(fish_array)
  end

  def roar()
    return "RROOOAAARR!!!"
  end

end
