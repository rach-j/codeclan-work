class RockPaperScissors
  def initialize(item1)
    @item1 = item1.downcase
    @item2 = ["rock", "paper", "scissors"]
  end

  def compare
    random_number = rand(0..2)
    computer_chooses = @item2[random_number]
    if @item1 == computer_chooses
      return "It's a draw!"
    elsif @item1 == "rock" and computer_chooses == "paper"
      return "Computer wins with paper!"
    elsif @item1 == "rock" and computer_chooses == "scissors"
      return "You win with rock!"
    elsif @item1 == "paper" and computer_chooses == "rock"
      return "You win with paper!"
    elsif @item1 == "paper" and computer_chooses == "scissors"
      return "Computer wins with scissors!"
    elsif @item1 == "scissors" and computer_chooses == "rock"
      return "Computer wins with rock!"
    else
      return  "You win with scissors!"
    end # if end
  end # def end
end # class end
