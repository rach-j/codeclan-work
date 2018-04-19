public class Radio extends Component {


    public Radio(String make, String model) {
        super(make, model);
    }

    public String tune(){
        return "Radio 1";
    }

    @Override
    public String play(String song) {
        return "I am playing on the Radio " + song;
    }

}
