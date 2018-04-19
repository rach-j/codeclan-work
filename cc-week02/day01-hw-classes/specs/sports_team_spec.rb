require ('minitest/autorun')

require_relative('../sports_team.rb')

class TestTeam < MiniTest::Test
  def setup
    team_array = ["Rachel",
                  "Nicki",
                  "Jen",
                  "Harriet",
                  "Max",
                  "Steve",
                  "Elliot",
                  "Adam"]
    @team = Team.new("The Mavericks", team_array, "Coach Steve")
  end

  def test_team_name
    name = @team.name()
    assert_equal("The Mavericks", name)
  end

  def test_team_players
    players = @team.players()
    assert_equal(["Rachel",
                  "Nicki",
                  "Jen",
                  "Harriet",
                  "Max",
                  "Steve",
                  "Elliot",
                  "Adam"], players)
  end

  def test_team_coach
    coach = @team.coach()
    assert_equal("Coach Steve", coach)
  end

  def test_set_coach_name
    @team.coach = "Big John"
    coach = @team.coach()
    assert_equal("Big John", coach)
  end

  def test_add_new_player
    @team.new_player("Tasha")
    new_team = @team.players()
    assert_equal(["Rachel",
                  "Nicki",
                  "Jen",
                  "Harriet",
                  "Max",
                  "Steve",
                  "Elliot",
                  "Adam",
                  "Tasha"], new_team)
  end

  def test_included_in_team__is_in_team
    result = @team.included_in_team?("Rachel")
    assert_equal(TRUE, result)
  end

  def test_included_in_team__is_not_in_team
    result = @team.included_in_team?("Morty")
    assert_equal(FALSE, result)
  end

  def test_updates_points__lose
    @team.game_outcome("lose")
    points = @team.points()
    assert_equal(0, points)
  end

  def test_updates_points__win
    @team.game_outcome("win")
    points = @team.points()
    assert_equal(1, points)
  end
end
