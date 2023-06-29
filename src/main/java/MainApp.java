

import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {
        //creating objects
        AnimalShelter animalShelter = new AnimalShelter();
        Monkey jonathan = new Monkey(true, 28, "Jonathan", 28, true);
        Monkey mary = new Monkey(false, 29, "mary", 29, true);
        Monkey leen = new Monkey(true, 27, "leen", 27, false);
        Monkey martin = new Monkey(false, 26, "martin", 26, false);
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        //adding animals to animalShelter
        animalShelter.addAnimal(jonathan);
        animalShelter.addAnimal(mary);
        animalShelter.addAnimal(leen);
        animalShelter.addAnimal(martin);
        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(cat2);
        animalShelter.addAnimal(cat3);
        animalShelter.addAnimal(dog1);
        animalShelter.addAnimal(dog2);
        animalShelter.addAnimal(dog3);


        //!!!uncomment methods to run them, there is an UNCOMMENTED print of animalShelter at the bottom!!!
        //sorting methods
//        animalShelter.sortAnimals(); //sorts by animalNumber ASC
//        animalShelter.sortAnimalsByAge(); //sorts by age ASC
//        animalShelter.sortAnimalsByName(); //sorts by name ASC

        //vaccinateAnimal
//        jonathan.vaccinateAnimal(Disease.POLIO);
//        jonathan.vaccinateAnimal(Disease.FLUE);
//        jonathan.vaccinateAnimal(Disease.CHICKENPOCKS);
//        jonathan.vaccinateAnimal(Disease.HEPATITISA);
//        jonathan.vaccinateAnimal(Disease.HEPATITISA);

        //printAnimalsNotVaccinated
        //this method also prints so check the correct print in the console
//        animalShelter.printAnimalsNotVaccinated(Disease.POLIO);
//        animalShelter.printAnimalsNotVaccinated(Disease.FLUE);
//        animalShelter.printAnimalsNotVaccinated(Disease.CHICKENPOCKS);
//        animalShelter.printAnimalsNotVaccinated(Disease.HEPATITISA);

        //findAnimal
        //string argument
//        System.out.println(animalShelter.findAnimal("JONATHAN"));//returns Optional<Animal>
//        System.out.println(animalShelter.findAnimal("NOTATHAN"));//returns empty Optional
        //int argument
        System.out.println(animalShelter.findAnimal(2));//returns Optional<Animal>
        System.out.println(animalShelter.findAnimal(-1));//returns empty Optional

        //treatAnimal
        //string argument
//        animalShelter.treatAnimal("Jonathan");
//        animalShelter.treatAnimal("Jonatan");
        //int argument
//        animalShelter.treatAnimal(0);
//        animalShelter.treatAnimal(-1);

        //treatAllAnimals
//        animalShelter.treatAllAnimals();

        //findOldestAnimal
//        System.out.println(animalShelter.findOldestAnimal());

        //printAnimals
        System.out.println("-".repeat(60));
        System.out.println("animalShelter.printAnimals() OUTPUT BELOW");
        animalShelter.printAnimals();
    }
}