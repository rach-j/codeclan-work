import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDPlayerTest {

    private CDPlayer player;

    @Before
    public void before(){
        player = new CDPlayer("Phillips","P24", 2);

    }

    @Test
    public void cnaGetMake(){
        assertEquals("Phillips", player.getMake());

    }

    @Test
    public void canGetModel() {
        assertEquals("P24", player.getModel());
    }

    @Test
    public void canGetNumberCD(){
        assertEquals(2, player.getNumberCD());
    }

    @Test
    public void canPlaySong(){
        assertEquals("I am playing on CD Lambada", player.play("Lambada") );
    }
}
