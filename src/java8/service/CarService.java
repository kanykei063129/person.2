package java8.service;

import java8.clases.Car;
import java8.clases.Person;

import java.util.List;

public interface CarService {
    String createCar(List<Car>cars);

    String removeCar(String name,List<Car>cars);

    List<Car>getAll();

    List<Person>findByName(String name,List<Person>people);

    List<Car>findByCountry(String name, List<Car> persons);
}
