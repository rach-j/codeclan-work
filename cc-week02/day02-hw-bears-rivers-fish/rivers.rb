class River
  attr_reader :name

  def initialize(name, fishes)
    @name = name
    @fishes = fishes
  end

  def get_fish()
    return @fishes
  end

  def number_of_fish
    return @fishes.length
  end
    # Fish count method
end
