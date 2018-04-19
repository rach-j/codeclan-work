package universe;

public class Universe {
    private static Universe instance;

    private String name;
    private int numberOfGalaxies;

    private Universe(String name, int numberOfGalaxies) {
        this.name = name;
        this.numberOfGalaxies = numberOfGalaxies;
    }

    public static Universe getInstance(String name, int numberOfGalaxies) {
        if(instance == null) {
            instance = new Universe(name, numberOfGalaxies);
        }
        return instance;
    }



 //  normal getters
    public String getName() {
        return this.name;
    }

    public int getNumberOfGalaxies() {
        return this.numberOfGalaxies;
    }

//    normal setter
    public void setName(String aNewName) {
        this.name = aNewName;
    }

}