require('minitest/autorun')
require('../person')

class PersonTest < MiniTest::Test
  def setup
    @person = Person.new("Rachel",29)
  end
end
