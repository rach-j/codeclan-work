require('minitest/autorun')
require_relative('../musician')
require_relative('../instrument')

class MusicianTest < MiniTest::Test
  def setup()
    strat = Instrument.new("Fender Strat", "guitar")
    @musician1 = Musician.new("Jimi Hendrix", strat)
    grand_piano = Instrument.new("Bechstein", "piano")
    @musician2 = Musician.new("Freddie Mercury", grand_piano)
  end

  def test_musician_has_name()
    name = @musician1.name()
    assert_equal("Jimi Hendrix", name)
  end

  def test_musician_can_play_song()
    song = @musician1.play_song("Hey Joe")
    assert_equal("I'm playing Hey Joe", song)
  end

  def test_musician_can_play_song__piano()
    song = @musician2.play_song("Bohemian Rhapsody")
    assert_equal("Plink plonk... I'm playing Bohemian Rhapsody", song)
  end
end
