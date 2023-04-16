package ru.dimash.spring.dao;


import org.springframework.stereotype.Component;
import ru.dimash.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PERSON_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PERSON_COUNT, "Josh Kim", 2000));
        people.add(new Person(++PERSON_COUNT, "John Kim", 1992));
        people.add(new Person(++PERSON_COUNT, "Miles Morais", 2003));
        people.add(new Person(++PERSON_COUNT, "Brandon Kim", 1980));
    }

    public List<Person> index(){
        return  people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PERSON_COUNT);
        people.add(person);
    }
}
