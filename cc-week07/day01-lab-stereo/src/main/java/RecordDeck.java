public class RecordDeck extends Component  implements IFunctions {

    private int playSpeed;

    public RecordDeck(String make, String model, int playSpeed) {
        super(make, model);
        this.playSpeed = playSpeed;
    }

    public int getPlaySpeed() {
        return this.playSpeed;
    }

    @Override
    public String play(String song) {
        return "I am playing on LP " + song;
    }
}
