require ('minitest/autorun')

require_relative('../codeclan_student.rb')

class TestStudent < MiniTest::Test
  def setup
    @student = Student.new("Rachel", 19)
  end

  def test_student_name
    name = @student.name()
    assert_equal("Rachel", name)
  end

  def test_student_cohort
    cohort = @student.cohort()
    assert_equal(19, cohort)
  end

  def test_set_student_name
    @student.set_name("Jussi")
    name = @student.name()
    assert_equal("Jussi", name)
  end

  def test_set_student_cohort
    @student.set_cohort(20)
    cohort = @student.cohort()
    assert_equal(20, cohort)
  end

  def test_student_talk
    talk = @student.talk()
    assert_equal("I can talk!", talk)
  end

  def test_say_favourite_language
    favourite_language_phrase = @student.say_favourite_language("Ruby")
    assert_equal("I love Ruby", favourite_language_phrase)
  end

end
