import java.util.ArrayList;
import java.util.Collections;

public class MagicEightBall {
    private ArrayList<String> responses;

    public MagicEightBall(ArrayList<String> responses) {
        this.responses = responses;
    }

    public ArrayList<String> getResponses() {
        ArrayList<String> copyOfResponses = new ArrayList<>(this.responses);
        return copyOfResponses;
    }

    public String getResponseAtIndex(int index) {
        return this.responses.get(index);
    }

    public String getRandomResponse() {
        Collections.shuffle(this.responses);
        return getResponseAtIndex(0);
    }

    public int getNumberOfResponses() {
        return this.responses.size();
    }

    public void addResponse(String response) {
        this.responses.add(response);
    }

    public void deleteResponse(int index) {
        this.responses.remove(index);
    }
}
