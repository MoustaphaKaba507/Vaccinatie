import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class AnimalShelterTest {
    private AnimalShelter shelter;
    private ByteArrayOutputStream outputStream;
    @BeforeEach
  public void setUp(){
        shelter =new AnimalShelter();
        outputStream =new ByteArrayOutputStream();

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
        shelter.addAnimal(jonathan);
        shelter.addAnimal(mary);
        shelter.addAnimal(leen);
        shelter.addAnimal(martin);
       shelter.addAnimal(cat1);
       shelter.addAnimal(cat2);
        shelter.addAnimal(cat3);
        shelter.addAnimal(dog1);
       shelter.addAnimal(dog2);
        shelter.addAnimal(dog3);

    }

 @AfterEach
 public void tearDown(){
    System.setOut(System.out);
    }

    @Test
      public void shouldReturnTrueIfAnimalIsSortByAge(){

        List<Animal> expected = new ArrayList<>(shelter.getAnimals());
        expected.sort(Comparator.comparing(Animal::getAnimalNumber));

        shelter.sortAnimalsByAge();
        List<Animal> actual = new ArrayList<>(shelter.getAnimals());

        assertEquals(expected,actual);
    }


    @Test
    public void shouldReturnTrueIfAnimalIsSortAnimalsByName(){

        List<Animal> expected  = new ArrayList<>(shelter.getAnimals());
        expected.sort(Comparator.comparing(Animal::getName));

        shelter.sortAnimalsByName();
        List<Animal> actual = shelter.getAnimals();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @EnumSource(Disease.class)
    public void printAnimalsNotVaccinated(Disease disease){
        System.setOut(new PrintStream(outputStream));

        shelter.printAnimalsNotVaccinated(disease);
        String actual = outputStream.toString();
        outputStream.reset();

        shelter.getAnimals().stream()
                .filter(animal -> !animal
                        .getIsVaccinated()
                        .get(disease))
                .forEach(System.out::println);
        String expected = outputStream.toString();

        assertEquals(expected,actual );

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 6})
    public void findAnimalsByNumber(int animalNumber){
        assertTrue(
                shelter.findAnimal(animalNumber).isPresent()
        );
    }

    @ParameterizedTest
    Collection<DynamicTest> findAnimalByname(){

        return Arrays.asList(
                dynamicTest("find leen",()->
                        assertTrue(shelter.findAnimal("leen").isPresent()))

        );

    }
    @ParameterizedTest
    @ValueSource(ints ={0, 1, 2, 3})
    void testFindAnimalByNumber(int animalNumber){

        shelter.findAnimal(animalNumber);

        Animal animalFoundByNumber = shelter.getAnimals()
                .stream()
                .filter(animal ->animal.getAnimalNumber() == animalNumber)
                .findFirst()
                .orElseThrow();

        assertEquals(animalFoundByNumber,shelter.findAnimal(animalNumber));

    }
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3})
    void testFindAnimalByName(String name){

        shelter.findAnimal(name);

        Animal animalFoundByName= shelter.getAnimals()
                .stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
        assertEquals(animalFoundByName,shelter.findAnimal(name));




    }

    @Test
    void treatAllAnimals(){
        shelter.treatAllAnimals();

        shelter.getAnimals().forEach(animal -> assertTrue(animal.getIsHealthy()));
    }

    @Test
    void findOldestAnimal(){
        Optional<Animal> oldestExpected =shelter.getAnimals()
                .stream()
                .max(Comparator.comparing(Animal::getAge));

        Optional<Animal> oldestActual =shelter.findOldestAnimal();

        assertEquals(oldestExpected,oldestActual);
    }
     @Test
    void countAnimals(){
         int actualSize =shelter.getAnimals().size();
         //then
         assertEquals(actualSize,shelter.countAnimals());

     }


}
