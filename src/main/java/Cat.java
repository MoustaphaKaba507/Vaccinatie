

public class Cat extends Animal {
    //properties
    private boolean hasLongNails;


    //constructors
    public Cat() {
        this(false, 0, "DEFAULT_CAT_NAME", 0, false);
    }

    public Cat(boolean isClean, int age, String name, int animalNumber, boolean hasLongNails) {
        super(isClean, age, name, animalNumber);
        this.hasLongNails = hasLongNails;
    }


    //getters & setters
    public boolean isHasLongNails() {
        return hasLongNails;
    }

    public void setHasLongNails(boolean hasLongNails) {
        this.hasLongNails = hasLongNails;
    }


    //custom methods
    @Override
    public void treatAnimal() {
        this.setClean(true);
        this.setHasLongNails(false);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "hasLongNails=" + hasLongNails +
                super.toString() +
                '}';
    }
}