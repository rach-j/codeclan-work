public class Rodan extends Kaiju {

    private String description;

    public Rodan(String name, int healthValue, int attackValue) {
        super(name, healthValue, attackValue);
        this.description = "Large pteranodon";
    }

    @Override
    public String roar() {
        return getName() + " emits a screeching sound almost unbearable to the human ear";
    }

    @Override
    public String move() {
        return getName() + " dives down to gauge the eyes out of its prey";
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
