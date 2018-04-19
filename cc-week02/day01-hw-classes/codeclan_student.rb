class Student

  # attr_reader :name, :cohort

  def initialize (name, cohort)
    @name = name
    @cohort = cohort
  end

  def name
    return @name
  end

  def cohort
    return @cohort
  end

  def set_name(name)
    @name = name
  end

  def set_cohort(cohort)
    @cohort = cohort
  end

  def talk()
    return "I can talk!"
  end

  def say_favourite_language(favourite_language)
    return "I love #{favourite_language}"
  end

end
