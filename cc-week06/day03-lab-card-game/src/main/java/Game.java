public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public String compareHands() {
        if (player1.getTotalValue() > player2.getTotalValue()) {
            player1.increaseScore();
            player1.resetHand();
            player2.resetHand();
            return player1.getName() + " Wins";
        }
        else if (player2.getTotalValue() > player1.getTotalValue()){
            player2.increaseScore();
            player1.resetHand();
            player2.resetHand();
            return player2.getName() + " Wins";
        }
        else {
            player1.increaseScore();
            player2.increaseScore();
            player1.resetHand();
            player2.resetHand();
            return player1.getName() + " and " + player2.getName() + " Draw";

        }
    }
}

