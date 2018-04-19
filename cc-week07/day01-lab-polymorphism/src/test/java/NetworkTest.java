import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkTest {

    Network network;
    Desktop desktop;
    InternetRadio internetRadio;

    @Before
    public void before() {
        network = new Network("CodeClan");
        desktop = new Desktop("Keith's Desktop", "Apple", "Macbook Pro");
    }

    @Test
    public void hasName(){
        assertEquals("CodeClan", network.getName());
    }

    @Test
    public void deviceListStartsEmpty() {
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectDesktop() {
        network.connect(desktop);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void shouldEmptyDeviceListAfterDisconnectingAll() {
        network.connect(desktop);
        network.disconnectAll();
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectRadio() {
        network.connect(internetRadio);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void returnSpareConnections() {
        network.connect(internetRadio);
        network.connect(internetRadio);
        network.connect(internetRadio);
        network.connect(internetRadio);
        assertEquals(1, network.freeConnectors());
    }

    @Test
    public void OnlyConnectionMaxNumber() {
        network.connect(internetRadio);
        network.connect(internetRadio);
        network.connect(internetRadio);
        network.connect(internetRadio);
        network.connect(internetRadio);
        network.connect(internetRadio);
        assertEquals(0, network.freeConnectors());
        assertEquals(5, network.deviceCount());
    }
}
