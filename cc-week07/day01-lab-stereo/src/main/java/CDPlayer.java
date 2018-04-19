public class CDPlayer extends Component  implements IFunctions  {

    private int NumberCD;

    public CDPlayer(String make, String model, int NumberCD) {
        super(make, model);
        this.NumberCD = NumberCD;
    }

    public int getNumberCd(){
        return this.NumberCD;
    }

    public int getNumberCD() {
        return this.NumberCD;
    }

    @Override
    public String play(String song) {
        return "I am playing on CD " + song;
    }


}
