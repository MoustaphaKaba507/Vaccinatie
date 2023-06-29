

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AnimalShelter {
    //properties
    private List<Animal> animals = new ArrayList<>();
    private int animalId;


    //constructors
    public AnimalShelter() {
        this(0);
    }

    public AnimalShelter(int animalId) {
        this.animalId = animalId;
    }


    //getters & setters
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }


    //custom methods
    public void printAnimals() {
        animals.forEach(System.out::println);
    }

    public void sortAnimals() {
        animals.sort(Comparator.comparing(Animal::getAnimalNumber));
    }

    public void sortAnimalsByName() {
        animals.sort(Comparator.comparing(Animal::getName));
    }

    public void sortAnimalsByAge() {
        animals.sort(Comparator.comparing(Animal::getAge));
    }

    public void printAnimalsNotVaccinated(Disease disease) {
        animals.stream().filter(animal -> !animal.getIsVaccinated().get(disease)).forEach(System.out::println);
    }

    public Optional<Animal> findAnimal(int animalNumber) {
        return animals.stream().filter(animal -> animal.getAnimalNumber() == animalNumber).findFirst();
    }

    public Optional<Animal> findAnimal(String name) {
        return animals.stream().filter(animal -> animal.getName().equalsIgnoreCase(name)).findFirst();
    }

    public void treatAnimal(int animalNumber) {
        Optional<Animal> searchResult = findAnimal(animalNumber);
        searchResult.ifPresent(Treatable::treatAnimal);
    }

    public void treatAnimal(String name) {
        Optional<Animal> searchResult = findAnimal(name);
        searchResult.ifPresent(Treatable::treatAnimal);
    }

    public void treatAllAnimals() {
        animals.forEach(Animal::treatAnimal);
    }

    public Optional<Animal> findOldestAnimal() {
        return animals.stream().max(Comparator.comparing(Animal::getAge));
    }

    public int countAnimals() {
        return animals.size();
    }

    public void addAnimal(Animal animal) {
        animal.setAnimalNumber(animalId++);
        animals.add(animal);
    }
}