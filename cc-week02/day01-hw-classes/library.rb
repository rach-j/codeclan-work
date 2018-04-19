class Library

attr_reader :books

  def initialize(books)
    @books = books
  end

  def book_details(name_of_book)
    for book in @books
      return book if book[:title] == name_of_book
    end
  end

  def rental_details(name_of_book)
    for book in @books
      return book[:rental_details] if book[:title] == name_of_book
    end
  end

  def add_book(name_of_book)
    new_book = {
      title: name_of_book,
      rental_details: {
        student_name: "",
        date: ""
           }
         }
    @books.push(new_book)
  end

  def change_rental_details(name_of_book, new_student, new_date)
    for book in @books
      if book[:title] == name_of_book
        book[:rental_details][:student_name] = new_student
        book[:rental_details][:date] = new_date
      end
    end
  end
end
