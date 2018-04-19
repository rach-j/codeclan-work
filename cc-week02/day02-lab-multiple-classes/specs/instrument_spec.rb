require('minitest/autorun')
require_relative('../instrument')

class InstrumentTest < MiniTest::Test
  def setup()
    @instrument = Instrument.new("Gibson Les Paul", "guitar")
  end

  def test_instrument_has_name()
    name = @instrument.name()
    assert_equal("Gibson Les Paul", name)
  end

  def test_instrument_has_type()
    type = @instrument.type()
    assert_equal("guitar", type)
  end

  def test_instrument_can_make_sound()
    sound = @instrument.make_sound("Stairway To Heaven")
    assert_equal("I'm playing Stairway To Heaven", sound)
  end

  def test_instrument_can_make_sound__piano()
    piano = Instrument.new("Yamaha", "piano")
    sound = piano.make_sound("Ordinary People")
    assert_equal("Plink plonk I'm playing Ordinary People", sound)
  end
end
