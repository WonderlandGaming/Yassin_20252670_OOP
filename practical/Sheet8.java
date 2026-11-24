package sheet8;

import java.util.Scanner;

class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double calculateRentalPrice(int days) {
        return days * 50.0;
    }

    public double calculateRentalPrice(int days, double discount) {
        return calculateRentalPrice(days) - discount;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }

    public String toString() {
        return "Vehicle [brand= " + brand + ", model= " + model + ", year= " + year + "]";
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    public double calculateRentalPrice(int days) {
        return days * 80.0;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    public String toString() {
        return "Car [brand= " + getBrand() + ", model= " + getModel() + ", year= " + getYear() + ", number-Of-Doors= " + numberOfDoors + "]";
    }
}

class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String brand, String model, int year, int engineCapacity) {
        super(brand, model, year);
        this.engineCapacity = engineCapacity;
    }

    public double calculateRentalPrice(int days) {
        return days * 40.0;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
    }

    public String toString() {
        return "Motorcycle [brand= " + getBrand() + ", model= " + getModel() + ", year= " + getYear() + ", engineCapacity= " + engineCapacity + "]";
    }
}

public class Sheet8 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2022, 4);
        Motorcycle moto = new Motorcycle("Yamaha", "MT-07", 2021, 689);

        car.displayDetails();
        System.out.println();
        moto.displayDetails();
        System.out.println();

        System.out.println("Car rental for 3 days: " + car.calculateRentalPrice(3));
        System.out.println("Motorcycle rental for 3 days: " + moto.calculateRentalPrice(3));
        System.out.println();

        System.out.println("Car rental for 3 days with 20 discount: " + car.calculateRentalPrice(3, 20.0));
        System.out.println("Motorcycle rental for 3 days with 15 discount: " + moto.calculateRentalPrice(3, 15.0));
        System.out.println();

        System.out.println(car);
        System.out.println(moto);
    }
}