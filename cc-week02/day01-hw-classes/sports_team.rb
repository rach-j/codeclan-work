class Team

  attr_reader :name, :players, :coach, :points

  attr_accessor :coach

  def initialize(name, players, coach)
    @name = name
    @players = players
    @coach = coach
    @points = 0
  end

  # def name()
  #   return @name
  # end

  # def players()
  #   return @players
  # end

  # def coach()
  #   return @coach
  # end

  # def set_coach(coach)
  #   @coach = coach
  # end

  def new_player(new_player_name)
    @players.push(new_player_name)
  end

  def included_in_team?(name)
    for player in @players
      return TRUE if player == name
    end
    return FALSE
  end

  def game_outcome(outcome)
    if outcome == "win"
      @points += 1
    end
  end
end
