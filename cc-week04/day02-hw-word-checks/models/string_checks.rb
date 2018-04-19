class StringChecks
  def initialize(string1, string2 = "")
    @string1 = string1
    @string2 = string2
  end

  def equal?()
    if @string1.downcase() == @string2.downcase()
      return "'#{@string1}' is equal to '#{@string2}'"
    else
      return "'#{@string1}' is not equal to '#{@string2}'"
    end
  end

  def palindrome?()
    if @string1.downcase() == @string1.downcase.reverse()
      return "'#{@string1}' is a palindrome"
    else
      return "'#{@string1}' is not a palindrome"
    end
  end

  def isogram?()
    no_spaces = @string1.downcase.delete(" ")
    duplicates_removed = no_spaces.chars.uniq()
    if no_spaces.chars() == duplicates_removed
      return "'#{@string1}' is an isogram"
    else
      return "'#{@string1}' is not an isogram"
    end
  end

  def anagram?()
    sorted1 = @string1.downcase.chars.sort()
    sorted2 = @string2.downcase.chars.sort()
    if sorted1 == sorted2
      return "'#{@string1}' is an anagram of '#{@string2}'"
    else
      return "'#{@string1}' is not an anagram of '#{@string2}'"
    end
  end
end
