require_relative('../db/sql_runner.rb')
require_relative('film.rb')
require_relative('screening.rb')

class TimeTable
  attr_reader :title, :show_time
  def initialize(options)
    @title = options['title']
    @show_time = options['show_time']
  end

  def TimeTable.all()
    sql = "SELECT screenings.show_time, films.title FROM screenings
    LEFT JOIN films
    ON screenings.film_id = films.id;"
    show_times = SqlRunner.run(sql)
    return show_times.map {|item| TimeTable.new(item)}
  end
end
