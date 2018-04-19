require('minitest/autorun')

require_relative('../library.rb')

class TestLibrary < MiniTest::Test
  def setup
    @library = Library.new(
      [
        {
          title: "lord_of_the_rings",
          rental_details: {
            student_name: "Jeff",
            date: "01/12/16"
          }
        },
        {
          title: "oryx_and_crake",
          rental_details: {
            student_name: "Rachel",
            date: "05/02/18"
          }
        },
        {
          title: "brave_new_world",
          rental_details: {
            student_name: "Grace",
            date: "15/01/17"
          }
        }
      ]
    )
  end

  def test_books
    books = @library.books()
    assert_equal(
      [
        {
          title: "lord_of_the_rings",
          rental_details: {
            student_name: "Jeff",
            date: "01/12/16"
          }
        },
        {
          title: "oryx_and_crake",
          rental_details: {
            student_name: "Rachel",
            date: "05/02/18"
          }
        },
        {
          title: "brave_new_world",
          rental_details: {
            student_name: "Grace",
            date: "15/01/17"
          }
        }
      ],
      books
    )
  end

  def test_book_details
    book_details = @library.book_details("oryx_and_crake")
    assert_equal(
      {
        title: "oryx_and_crake",
        rental_details: {
          student_name: "Rachel",
          date: "05/02/18"
        }
      },
      book_details)
    end

    def test_rental_details
      rental_details = @library.rental_details("oryx_and_crake")
      assert_equal(
        {
          student_name: "Rachel",
          date: "05/02/18"
        },
        rental_details)
      end

      def test_add_book
        updated_library = @library.add_book("1984")
        assert_equal(
          [
            {
              title: "lord_of_the_rings",
              rental_details: {
                student_name: "Jeff",
                date: "01/12/16"
              }
            },
            {
              title: "oryx_and_crake",
              rental_details: {
                student_name: "Rachel",
                date: "05/02/18"
              }
            },
            {
              title: "brave_new_world",
              rental_details: {
                student_name: "Grace",
                date: "15/01/17"
              }
            },
            {
              title: "1984",
              rental_details: {
                student_name: "",
                date: ""
              }
            }
            ], updated_library)
          end

          def test_change_rental_details
            updated_library = @library.change_rental_details("brave_new_world",
              "Sara", "01/02/17")
              assert_equal(
                [
                  {
                    title: "lord_of_the_rings",
                    rental_details: {
                      student_name: "Jeff",
                      date: "01/12/16"
                    }
                  },
                  {
                    title: "oryx_and_crake",
                    rental_details: {
                      student_name: "Rachel",
                      date: "05/02/18"
                    }
                  },
                  {
                    title: "brave_new_world",
                    rental_details: {
                      student_name: "Sara",
                      date: "01/02/17"
                    }
                  }
                  ], updated_library)
                end
              end
