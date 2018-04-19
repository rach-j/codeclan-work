require_relative('../models/student.rb')
require_relative('../models/house.rb')

Student.delete_all()
House.delete_all()

house1 = House.new({
  "name" => "Gryffindor",
  "url" => "https://ssli.ebayimg.com/images/g/FpgAAOxyGStRyHtW/s-l640.jpg"
})

house2 = House.new({
  "name" => "Hufflepuff",
  "url" => "https://i.ebayimg.com/images/g/OkwAAMXQDK1RyAuO/s-l300.jpg"
})

house3 = House.new({
  "name" => "Ravenclaw",
  "url" => "https://i.ebayimg.com/images/g/I2QAAOxyY3ZRyHoY/s-l300.jpg"
})

house4 = House.new ({
  "name" => "Slytherin",
  "url" => "https://i.ebayimg.com/images/g/dsEAAOxy~g5RyHoG/s-l300.jpg"
  })

house1.save()
house2.save()
house3.save()
house4.save()

student1 = Student.new({
  "first_name" => "Harry",
  "last_name" => "Potter",
  "house_id" => house1.id(),
  "age" => 13
  })

student2 = Student.new({
  "first_name" => "Cedric",
  "last_name" => "Diggory",
  "house_id" => house2.id(),
  "age" => 15
  })

student3 = Student.new({
  "first_name" => "Luna",
  "last_name" => "Lovegood",
  "house_id" => house3.id(),
  "age" => 13
  })

student4 = Student.new({
  "first_name" => "Draco",
  "last_name" => "Malfoy",
  "house_id" => house4.id(),
  "age" => 13
  })

student1.save()
student2.save()
student3.save()
student4.save()
