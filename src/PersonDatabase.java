import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PersonDatabase {
    private List<Person> people = new ArrayList<>();

    public void add(Person person) {
        //if (person == null)
         //   throw new NullPointerException("Cannot add null reference");
        //if (findById(person.getId()).isPresent())
          //  throw new IllegalArgumentException("Object with such id already exists");
       // findById(person.getId()).ifPresent(p->{
          //          throw new IllegalArgumentException("Object with such id already exists");
           //     });
        Optional.ofNullable(person).ifPresentOrElse(
                p-> findById(p.getId()).ifPresent(person1 -> {
                    throw new IllegalArgumentException("Object with such id already exists");}),
                ()-> {throw new NullPointerException("Cannot add null reference");
                }
        );
        people.add(person);
    }

    public Optional<Person> findById(int id) {
        for (Person person : people) {
            if (person.getId() == id)
                return Optional.of(person);
        }
        //return null;
        return Optional.empty();
    }
    public String findLastNameById(int i){
        return findById(i)
                .map(Person::getLastName)
                .orElse("Anonim");
        //if(s.isPresent()){
        //return s.get();
        }
        //for (Person person1 : people) {
           // if(person1.getId()==i){
          //      return person1.getLastName();
          //  }
        //}

       // return "Anonim";

}