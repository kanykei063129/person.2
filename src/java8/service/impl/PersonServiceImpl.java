package java8.service.impl;

import java8.clases.Car;
import java8.clases.Person;
import java8.enums.Gender;
import java8.service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PersonServiceImpl implements PersonService {
    List<Person>people = new ArrayList<>();
    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "WAS SUCCESSFUL!!!";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        for (Person person : people) {
            if(name.equals(person.getName())){
                this.people.remove(person);
            }
        }
        return  name +"Removed!!!";
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person>people1 = new ArrayList<>();
        for (Person person : people) {
            if(name.equals(person.getName())){
                people1.add(person);
                return people1;
            }
        }
        return null;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person>people1 = new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if(car.getName().equals(name)){
                    people1.add(person);
                    return people1;
                }
            }
        }
        return null;
    }

    @Override
    public String payCars(String name, List<Person> person, String carName, List<Car> cars) {

        for (Person person1 : person) {
            if (person1.getName().equals(name)){
                for (Car car : cars) {
                    if(car.getName().equals(carName)){
                        int rezult = person1.getMoney().compareTo(car.getPrice());
                        if(rezult == 1){
                            person1.setMoney(person1.getMoney().subtract(car.getPrice()));
                            person1.getCars().add(car);
                            cars.remove(car);
                            return "Иought a car!!! \n"+person1;
                        }else if (rezult<0){
                            return "YOU DON'T HAVE ENOUGH MONEY!!!";
                        }else {
                            return "error";
                        }
                    }
                }
            }

        }

        return null;
    }
    public Comparator<Person>sortPersonDateOfBirthsort1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };
    public Comparator<Person>sortPersonDateOfBirthsort2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getDateOfBirth().compareTo(o1.getDateOfBirth());
        }
    };

    @Override
    public List<Person> sortPersonDateOfBirth(int num,List<Person> persons) {
        List <Person> kk = new ArrayList<>();
        kk.addAll(persons);
        if (num==1){
            kk.sort(sortPersonDateOfBirthsort1);
        }else if (num==2){
            kk.sort(sortPersonDateOfBirthsort2);
        }
        return kk;
    }
    public Comparator<Person>sortPersonNamesort1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public Comparator<Person>sortPersonNamesort2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    @Override
    public List<Person> sortPersonName(int num,List<Person> persons) {
        List<Person>pp = new ArrayList<>();
        pp.addAll(persons);
        if (num==1){
            pp.sort(sortPersonNamesort1);
        }else if (num==2){
            pp.sort(sortPersonNamesort2);
        }
        return pp;
    }
    public Comparator<Person>personComparatorGender1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().compareTo(o2.getGender());
        }
    };
    public Comparator<Person>personComparatorGender2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getGender().compareTo(o1.getGender());
        }
    };

    @Override
    public List<Person> sortGender(int num,List<Person> person) {
        if(num==1){
            person.sort(personComparatorGender1);
        } else if (num==2) {
            person.sort(personComparatorGender2);
        }else {
            return null;
        }

        return person;
    }

    @Override
    public int getAge(String name,List<Person> person) {
        for (Person person1 : person) {
            if (person1.getName().equals(name)){
                int age = Period.between(person1.getDateOfBirth(),LocalDate.now()).getYears();
                return age;
            }
        }
        return 0;
    }
}
