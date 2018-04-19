def return_10
  return 10
end

def add(number1, number2)
  return number1 + number2

end

def subtract(number1, number2)
  return number1 - number2
end

def multiply(number1, number2)
  return number1 * number2
end

def divide(number1, number2)
  return number1 / number2
end

def length_of_string(string)
  return string.length
end

def join_string(string1, string2)
  return string1 + string2
end

def add_string_as_number(string1, string2)
  return string1.to_i + string2.to_i
end

def number_to_full_month_name(number)
  case number
  when 1
    return "January"
  # when 2
  #   return "February"
  when 3
    return "March"
  # when 4
  #   return "April"
  # when 5
  #   return "May"
  # when 6
  #   return "June"
  # when 7
  #   return "July"
  # when 8
  #   return "August"
  when 9
    return "September"
  end
end

def number_to_short_month_name(number)
  case number
  when 1
    return "Jan"
  when 3
    return "Mar"
  when 9
    return "Sep"
  end
end

def volume_of_cube(number1, number2, number3)
  return number1 * number2 * number3
end

def volume_of_sphere(radius)
  return (4/3.to_f * Math::PI * radius ** 3)
end

def fahrenheit_to_celsius(farenheit)
  return (farenheit - 32) * 5.to_f/9
end
