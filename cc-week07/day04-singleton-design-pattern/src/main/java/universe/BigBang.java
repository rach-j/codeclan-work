package universe;

public class BigBang {
    public BigBang(){}

    public Universe makeUniverse(String name, int numberOfGalaxies){
        return Universe.getInstance(name, numberOfGalaxies);
    }

}
