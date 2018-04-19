public class InternetRadio implements IConnect {
    InternetRadio internetRadio;

    @Override
    public String connect(String data) {
        return "Connecting to: " + data + " network";
    }

    public String tuneToStation(String station) {
        return "I am tuned to station: " + station;
    }
}
