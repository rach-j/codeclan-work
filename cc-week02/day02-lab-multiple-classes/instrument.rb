class Instrument
  attr_reader(:name, :type)

  def initialize(name, type)
    @name = name
    @type = type
  end

  def make_sound(song_title)
    if @type == "piano"
      return "Plink plonk... I'm playing #{song_title}"
    else
      return "I'm playing #{song_title}"
    end
  end
end
