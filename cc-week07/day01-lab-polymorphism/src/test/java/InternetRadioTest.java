import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InternetRadioTest {
    private InternetRadio internetRadio;

    @Before
    public void before() {
        internetRadio = new InternetRadio();
    }

    @Test
    public void canTuneToStation() {
        assertEquals("I am tuned to station: Radio 2", internetRadio.tuneToStation("Radio 2"));
    }
}
