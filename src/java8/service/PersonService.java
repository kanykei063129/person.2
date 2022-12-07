package java8.service;

import java8.clases.Car;
import java8.clases.Person;

import java.util.List;

public interface PersonService {
    String createPerson(List<Person> people);

    String removePerson(String name, List<Person> people);

    List<Person> getAll();

    List<Person> findByName(String name, List<Person> people);

    List<Person> findByCarName(String name, List<Person> people);

    String payCars(String name, List<Person> person, String carName, List<Car> cars);

    List<Person>sortPersonDateOfBirth(int num,List<Person>persons);

    List<Person>sortPersonName(int num,List<Person>persons);

    List<Person>sortGender(int num,List<Person>person);

    int getAge(String name,List<Person> person);
}
