import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

class PersonTest {
    public static void main(String[] args) {
        //System.out.println(new Person(1,"Kuba","Słomiński"));
        PersonDatabase db = new PersonDatabase();
        db.add(new Person(1, "Jan", "Kowalski"));
        db.add(new Person(2, "Karol", "Zawadzki"));
        db.add(new Person(3, "Bartosz", "Abacki"));
        db.add(new Person(4, "Ania", "Walczak"));


        //Optional<Object> o = Optional.of(null); // to juz rzuci błąd
        //System.out.println(o.get());
        Optional<Person> person1 = db.findById(2); // Karol Zawadzki
        if (person1.isPresent()){
            System.out.println(person1.get().getLastName());
        }
        //person1.ifPresent(p-> System.out.println(p.getLastName()));
        Consumer<Person> consumer = p -> System.out.println(p.getFirstName());
        person1.ifPresent(PersonTest::printName);
        String lastNameById = db.findLastNameById(1);
        System.out.println(lastNameById);

        Person person4 = new Person();
       // person1.ifPresent(System.out::println);
        //person1.ifPresent(Person::setFirstName);
        //person1.ifPresent(System.out::println);
        //System.out.println(person4.getFirstName());

        Optional<Person> personNull = db.findById(55); // null
        if(personNull.isPresent()){
            System.out.println(personNull.get().getLastName());
        }else {
            System.out.println("Brak osoby o id: ");
        }
        personNull.ifPresentOrElse(
                PersonTest::printName,
                ()-> System.out.println("Obiekt o wskazanym id nie istnieje")
        );

        Person person2 = null;
        Person person3 = new Person();
        int id = person3.getId();
        //System.out.println(id);
        //System.out.println(person1.getLastName());
        //System.out.println(personNull.getLastName()); //NullPointerException
        //mozna by tu zrobic ifa, ktory sorawdza czy obiekt nie jest nulle, a jesli nie to moze wykonac na nim operacje
        // ale po co? Od tego mamy Optionala

        Optional<Object> empty = Optional.empty();
        Optional<Person> person = Optional.of(new Person(1, "Kuba", "Słomiński"));
        Optional<Optional<Person>> personNull1 = Optional.ofNullable(personNull);

    }
    private static void printName(Person p){
        System.out.println(p.getLastName());
    }
}
