

public class Dog extends Animal {
    //properties
    private boolean hasFoulBreath;


    //constructors
    public Dog() {
        this(false, 0, "DEFAULT_DOG_NAME", 0, false);
    }

    public Dog(boolean isClean, int age, String name, int animalNumber, boolean hasFoulBreath) {
        super(isClean, age, name, animalNumber);
        this.hasFoulBreath = hasFoulBreath;
    }


    //getters & setters
    public boolean isHasFoulBreath() {
        return hasFoulBreath;
    }

    public void setHasFoulBreath(boolean hasFoulBreath) {
        this.hasFoulBreath = hasFoulBreath;
    }


    //custom methods
    @Override
    public void treatAnimal() {
        this.setClean(true);
        this.setHasFoulBreath(false);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "hasFoulBreath=" + hasFoulBreath +
                super.toString() +
                '}';
    }
}