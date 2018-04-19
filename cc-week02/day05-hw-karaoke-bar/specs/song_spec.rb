require('minitest/autorun')
require_relative('../song')

class TestSong < MiniTest::Test
  def setup
    @song1 = Song.new("Smells Like Teen Spirit")
  end

  def test_song_name
    name = @song1.song_name()
    assert_equal("Smells Like Teen Spirit", name)
  end
end
