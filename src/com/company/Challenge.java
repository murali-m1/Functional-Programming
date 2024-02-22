package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Challenge {

    static class Person {
        public final String name;
        public final Integer age;

        Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        public final String make;
        public final String color;
        public final Float price;

        Car(String make, String color, Float price) {
            this.make = make;
            this.color = color;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "make='" + make + '\'' +
                    ", color='" + color + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Person[] peopleArray = {
                new Person("Sam", 23),
                new Person("Ram", 34),
                new Person("Micheal", 22),
                new Person("Sara", 19),
                new Person("Tamil", 28)
        };
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArray));
        //Get a list that contains all the people's names
        List<String> allPeoples = people.stream()
                .map((person) -> person.name).collect(Collectors.toList());
        System.out.println(allPeoples);

        Car[] carsArray = {
                new Car("Suzuki", "red", 4500f),
                new Car("Ford", "blue", 2300f),
                new Car("Toyota", "grey", 1400f),
                new Car("Lamboghini", "blue", 1500f),
                new Car("Renault", "blue", 1500f)
        };
        List<Car> cars = new ArrayList<>(Arrays.asList(carsArray));
        //Get a list of all blue cars
        List<Car> allBlueCars = cars
                .stream()
                .filter((car) -> car.color == "blue").collect(Collectors.toList());
        System.out.println(allBlueCars);

        Employee[] employeeArray = {
                new Employee("Mano", 43, "Manager", 34500f),
                new Employee("Samuel", 35, "Executive", 34000f),
                new Employee("Priya", 28, "Developer", 42000f),
                new Employee("Mohan", 28, "Developer", 31000f),
                new Employee("Ini", 28, "Developer", 35000f),
                new Employee("Nana", 21, "Junior", 14000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeeArray));
        //Find the sum of all of the employee's salaries
        Float sumOfSalaries = employees
                .stream()
                .map((employee) -> employee.salary)
                .reduce(0f,(acc,x) -> acc+x);
        System.out.println(sumOfSalaries);

        //Combine list functions - Find the average salary of the developers
        Float totalDeveloperSalaries = employees
                .stream()
                .filter((employee) -> employee.jobTitle == "Developer")
                .map(developer -> developer.salary)
                .reduce(0f,(acc,x) -> acc+x);
        System.out.println("totalDeveloperSalaries - " + totalDeveloperSalaries);

        Long numberOfDevelopers = employees
                .stream()
                .filter(employee -> employee.jobTitle == "Developer")
                .count();
        System.out.println( "numberOfDevelopers - " + numberOfDevelopers);

        float averageDeveloperSalary = totalDeveloperSalaries/numberOfDevelopers;
        System.out.println("averageDeveloperSalary - " + averageDeveloperSalary);
    }
}
