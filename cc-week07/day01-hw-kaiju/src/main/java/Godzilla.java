public class Godzilla extends Kaiju {

    private String description;

    public Godzilla(String name, int healthValue, int attackValue) {
        super(name, healthValue, attackValue);

//        To make healthvalue default for each monster, delete attack value in public class and fix attackValue in super.
        this.description = "Large prehistoric sea monster";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String roar() {
        return getName() + " roars in a way that only Godzillas can";
    }

    @Override
    public String move() {
        return getName() + " runs forward, crushing everything in its path";
    }
}
