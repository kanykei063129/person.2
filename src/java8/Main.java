package java8;

import java8.clases.Car;
import java8.clases.Person;
import java8.enums.Colour;
import java8.enums.Country;
import java8.enums.Gender;
import java8.service.CarService;
import java8.service.impl.CarServiceImpl;
import java8.service.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {


            Scanner scanner = new Scanner(System.in);
            Car car1 = new Car("BMW", "X7", new BigDecimal(500000), Year.of(2000), Colour.WRITE, Country.ITALY);
            Car car2 = new Car("Tayota", "camry", new BigDecimal(650000), Year.of(2004), Colour.BLUE, Country.RUSSIA);
            Car car3 = new Car("Mercedes", "Bens", new BigDecimal(455000), Year.of(2002), Colour.BLACK, Country.EUROPE);
            Car car4 = new Car("Audi", "A3 Sedan", new BigDecimal(550000), Year.of(2003), Colour.RED, Country.KYRGYZSTAN);
            List<Car> cars = new ArrayList<>(List.of(car1, car2, car3, car4));


            Person person1 = new Person("Kanykei", LocalDate.of(2006, 03, 19), Gender.FAMELE, new BigDecimal(650000), "+996706050119", cars);
            Person person2 = new Person("Adil", LocalDate.of(2004, 03, 17), Gender.MALE, new BigDecimal(500000), "+996702219220", cars);
            Person person3 = new Person("Erlan", LocalDate.of(2001, 9, 11), Gender.MALE, new BigDecimal(550000), "+996507862202", cars);
            List<Person> people = new ArrayList<>(List.of(person1, person2, person3));
            PersonServiceImpl personService = new PersonServiceImpl();
            personService.createPerson(people);
            CarServiceImpl carService = new CarServiceImpl();
            carService.createCar(cars);
            while (true) {
                System.out.println("""
                        1 GET PERSON!
                        2 REMOVE PERSON!
                        2 FIND BY NAME!
                        4 FIND BY CARE NAME! 
                        5 PAY CARS!
                        6 SORT PERSON DATE OF BORDS!
                        7 SORT PERSON NAME!
                        8 SORT GENDER!
                        9 GET AGE!
                        10 REMOVE CAR!
                        11 GET ALL CAR!
                        12 FIND BY COUNTRY!""");
                System.out.println("san beriniz:");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        System.out.println(personService.getAll());
                        break;
                    case 2:
                        String word = scanner.nextLine();
                        System.out.print("REMOVE PERSON : ");
                        System.out.println(personService.removePerson(scanner.nextLine(), people));
                        System.out.println(personService.getAll());
                        break;
                    case 3:
                        String word1 = scanner.nextLine();
                        System.out.print("FIND BY NAME : ");
                        String word2 = scanner.nextLine();
                        System.out.println(personService.findByName(word2, people));
                        break;
                    case 4:
                        String word4 = scanner.nextLine();
                        System.out.print("FIND BY CAR NAME : ");
                        System.out.println(personService.findByCarName(scanner.nextLine(), people));
                        break;
                    case 5:
                        String word5 = scanner.nextLine();
                        System.out.print("PERSON NAME : ");
                        String name1 = scanner.nextLine();
                        while (true) {

                            System.out.print("CAR NAME : ");
                            String carName1 = scanner.nextLine();
                            System.out.println(personService.payCars(name1, people, carName1, cars));
                            if ((personService.payCars(name1, people, carName1, cars) == ("You don't have enough money!!!"))) {
                                break;
                            }
                        }
                        break;


                    case 6:
                        System.out.println("PRESS 1 = 1-2");
                        System.out.println("PRESS 2 = 2-1");
                        System.out.print("PRESS : ");
                        System.out.println(personService.sortPersonDateOfBirth(scanner.nextInt(), people));
                        break;
                    case 7:
                        System.out.println("PRESS 1 = A-Я");
                        System.out.println("PRESS 2 = Я-А");
                        System.out.print("PRESS : ");
                        System.out.println(personService.sortPersonName(scanner.nextInt(), people));
                        break;
                    case 8:
                        System.out.println("PRESS 1 = M-F");
                        System.out.println("PRESS 2 = F-M");
                        System.out.print("PRESS : ");
                        System.out.println(personService.sortGender(scanner.nextInt(), people));
                        break;
                    case 9:
                        String name4 = scanner.nextLine();
                        System.out.print("PRESS PERSON NAME : ");
                        System.out.println(personService.getAge(scanner.nextLine(), people));
                        break;
                    case 10:
                        String m = scanner.nextLine();
                        System.out.print("REMOVE CAR : ");
                        carService.removeCar(scanner.nextLine(), cars);
                        System.out.println(carService.getAll());
                        break;
                    case 11:
                        System.out.println(carService.getAll());
                        break;
                    case 12:
                        String na = scanner.nextLine();
                        System.out.print("FIND BY  COUNTRY : ");
                        System.out.println(carService.findByCountry(scanner.nextLine(), cars));
                        break;
                    default:
                        System.out.println("YOU ENTERED A WRONG COMBINATION!!!");
                        break;
                }
            }

        } catch (
                InputMismatchException e) {

            System.err.println("you entered a number instead of letters!!!");
        }
    }
}