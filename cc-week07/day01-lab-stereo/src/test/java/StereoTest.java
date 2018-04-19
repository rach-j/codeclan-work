import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StereoTest {
    private Stereo stereo;

    @Before
    public void before() {
        stereo = new Stereo("David's stereo");
    }

    @Test
    public void canTune() {
        assertEquals("Radio 1", stereo.tuneRadio());
    }

    @Test
    public void canGetStereoName(){
        assertEquals("David's stereo", stereo.getName());
    }

    @Test
    public void canPlaySongFromCD(){
        assertEquals("I am playing on CD Wannabe", stereo.playSongFromCD("Wannabe"));
    }

    @Test
    public void canPlaySongFromRecord(){
        assertEquals("I am playing on LP Beat it", stereo.playSongFromRecordPlayer("Beat it"));
    }

    @Test
    public void getVolumeOfStereo() {
        assertEquals(20,stereo.getVolumeOfStereo());
    }

    @Test
    public void RaiseVolumeOfStereo() {
        String result = stereo.raiseVolumeOfStereo();
        assertEquals("Volume up by 1", result);
        assertEquals(21,stereo.getVolumeOfStereo());
    }

    @Test
    public void decreaseVolumeOfStereo(){
        String result = stereo.decreaseVolumeOfStereo();
        assertEquals("Volume down by 1", result);
        assertEquals(19, stereo.getVolumeOfStereo());
    }


    @Test
    public void decreaseVolumeOfStereo(){
        stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
        stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
        stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
       stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
         stereo.decreaseVolumeOfStereo();
        String result = stereo.decreaseVolumeOfStereo();
        assertEquals("Volume already zero", result);
        assertEquals(0, stereo.getVolumeOfStereo());
    }

}
