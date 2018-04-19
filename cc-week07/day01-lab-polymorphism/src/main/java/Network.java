import java.util.*;

public class Network {
    private String name;
    private ArrayList<IConnect> devices;
    private int maxConnections;

    public Network(String name){
        this.devices = new ArrayList<>();
        this.name = name;
        this.maxConnections = 5;
    }

    public String getName() {
        return name;
    }

    public int deviceCount() {
        return devices.size();
    }

    public void connect(IConnect device) {
        if (freeConnectors() != 0) {
            devices.add(device);
        }
    }

    public void disconnectAll(){
        devices.clear();
    }

    public int freeConnectors() {
        return this.maxConnections - this.deviceCount();
    }
}