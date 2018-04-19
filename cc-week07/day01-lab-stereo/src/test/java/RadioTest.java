import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    private Radio radio;

    @Before
    public void before(){
        radio = new Radio("Panasonic", "XY54");

    }

    @Test
    public void cnaGetMake(){
        assertEquals("Panasonic", radio.getMake());

    }

    @Test
    public void canGetModel() {
        assertEquals("XY54", radio.getModel());
    }

    @Test
    public void canGetTune() {
        assertEquals("Radio 1", radio.tune());
    }

    @Test
    public void canPlaySong() {
        assertEquals("I am playing on the Radio Mama Mia", radio.play("Mama Mia"));
    }
}
