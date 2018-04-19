require('pg')

class Bounty

  attr_accessor :name, :species, :bounty_value, :danger_level
  attr_reader :id

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @name = options['name']
    @species = options['species']
    @bounty_value = options['bounty_value'].to_i
    @danger_level = options['danger_level']
  end

  def save()
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    sql =
    "INSERT INTO space_cowboys (
    name,
    species,
    bounty_value,
    danger_level
    )
    VALUES
    (
      $1, $2, $3, $4
      )
      RETURNING *;
      "
      values = [@name, @species, @bounty_value, @danger_level]
      db.prepare("save", sql)
      @id = db.exec_prepared("save", values)[0]['id']
      db.close()
  end

  def delete()
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    sql = "DELETE FROM space_cowboys WHERE id = $1"
    values =[@id]
    db.prepare("delete", sql)
    db.exec_prepared("delete", values)
    db.close()
  end

  def update()
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    sql = "UPDATE space_cowboys
    SET(
      name,
      species,
      bounty_value,
      danger_level
      )=
      (
        $1, $2, $3, $4
        )
        WHERE id = $5;
        "
      values = [@name, @species, @bounty_value, @danger_level, @id]
      db.prepare("update", sql)
      db.exec_prepared("update", values)
      db.close()
  end

  def Bounty.find(id_number)
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    sql = "SELECT * FROM space_cowboys WHERE id = $1;"
    values = [id_number]
    db.prepare("find", sql)
    result = db.exec_prepared("find", values)
    db.close()
    return result.map {|cowboy| Bounty.new(cowboy)}
  end

  def Bounty.all()
    db = PG.connect({dbname: 'space_cowboys', host: 'localhost'})
    sql = "SELECT * FROM space_cowboys"
    values = []
    db.prepare("all", sql)
    result = db.exec_prepared("all", values)
    db.close()
    return result.map {|cowboy| Bounty.new(cowboy)}
  end

end
