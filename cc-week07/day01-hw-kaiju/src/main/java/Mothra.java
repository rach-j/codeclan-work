public class Mothra extends Kaiju {

    private String description;

    public Mothra(String name,int healthValue, int attackValue) {
        super(name, healthValue, attackValue);
        this.description = "Colossal sentient month";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String roar() {
        return getName() + " gives a high-pitched whirring roar as Mothra are wont to do";
    }

    @Override
    public String move() {
        return getName() + " soars high up in the air ready to pounce on unsuspecting humans";
    }
}
