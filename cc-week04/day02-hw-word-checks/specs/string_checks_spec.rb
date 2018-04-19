require('minitest/autorun')
require_relative('../models/string_checks.rb')

class TestStringChecks < MiniTest::Test

  def test_equal_strings__are_equal
    strings = StringChecks.new("I like Ruby","i like Ruby")
    result = strings.equal?()
    assert_equal("'I like Ruby' is equal to 'i like Ruby'", result)
  end

  def test_equal_strings__are_not_equal
    strings = StringChecks.new("I like Ruby","I hate Ruby")
    result = strings.equal?()
    assert_equal("'I like Ruby' is not equal to 'I hate Ruby'", result)
  end

  def test_equal_palindrome__is_palindrome
    string = StringChecks.new("Racecar racecar")
    result = string.palindrome?()
    assert_equal("'Racecar racecar' is a palindrome", result)
  end

  def test_equal_palindrome__is_not_palindrome
    string = StringChecks.new("I love Ruby")
    result = string.palindrome?()
    assert_equal("'I love Ruby' is not a palindrome", result)
  end

  def test_equal_isogram__is_isogram
    string = StringChecks.new("I love Ruby")
    result = string.isogram?()
    assert_equal("'I love Ruby' is an isogram", result)
  end

  def test_equal_isogram__is_not_isogram
    string = StringChecks.new("I looooovvvve Ruby")
    result = string.isogram?()
    assert_equal("'I looooovvvve Ruby' is not an isogram", result)
  end

  def test_anagram__is_anagram
    strings = StringChecks.new("I love Ruby", "Rybu evil o")
    result = strings.anagram?()
    assert_equal("'I love Ruby' is an anagram of 'Rybu evil o'", result)
  end

  def test_anagram__is_not_anagram
    strings = StringChecks.new("I love Ruby", "I hate Ruby")
    result = strings.anagram?()
    assert_equal("'I love Ruby' is not an anagram of 'I hate Ruby'", result)
  end
end
