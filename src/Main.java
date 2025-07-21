import account.Account;
import account.SavingsAccount;
import account.CreditAccount;

import vehicle.Vehicle;
import vehicle.Truck;
import vehicle.Drone;

import animal.Animal;
import animal.Lion;
import animal.Parrot;

import java.util.List;
import java.util.ArrayList;

import character.Warrior;
import character.Mage;

public class Main {
    public static void main(String[] args) {
        // 1. Банковские счета

        //Базовый класс Account
        Account account = new Account();
        account.displayInfo();

        account.deposit(100.0);
        account.displayInfo();

        account.withdraw(50.0);
        account.displayInfo();

        account.withdraw(-10.0);
        account.displayInfo();

        // Класс SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.displayInfo();

        savingsAccount.deposit(2000.0);
        savingsAccount.displayInfo();

        savingsAccount.withdraw(500.0);
        savingsAccount.displayInfo();

        savingsAccount.withdraw(1100.0);
        savingsAccount.displayInfo();

        savingsAccount.applyInterest();
        savingsAccount.displayInfo();

        // Класс CreditAccount
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.displayInfo();

        creditAccount.withdraw(40000.0);
        creditAccount.displayInfo();

        creditAccount.withdraw(70000.0);
        creditAccount.displayInfo();

        // 2. Система доставки

        // Базовый класс Vehicle
        Vehicle vehicle = new Vehicle(300, 1000);
        vehicle.deliver("Москва");

        // Класс Truck
        Truck truck = new Truck(150, 20000);
        truck.deliver("Санкт-Петербург");
        startDelivery(truck, "Куда-то далеко");

        // Класс Drone
        Drone drone = new Drone(400, 100);
        drone.deliver("Далеко");
        startDelivery(drone, "Куда-то недалеко");

        // 3. Зоопарк

        // Базовый класс Animal
        Animal animal = new Animal("Тигр", 5);
        animal.makeSound();
        animal.eat();

        // Класс Lion
        Lion lion = new Lion(3);
        lion.makeSound();
        lion.eat();
        lion.hunt();

        // Класс Parrot
        Parrot parrot = new Parrot(300);
        parrot.makeSound();
        parrot.eat();

        // Вольер с разными животными
        List<Animal> aviary = new ArrayList<>();
        aviary.add(new Animal("Животное", 5));
        aviary.add(new Lion(5));
        aviary.add(new Parrot(250));
        for(Animal aviaryAnimal: aviary) {
            aviaryAnimal.makeSound();
        }

        // 4. Игровые персонажи
        Warrior warrior = new Warrior(3);
        Mage mage = new Mage(2);

        System.out.println("\nСражение воина и мага");
        System.out.println("Атакуют друг друга по очереди");
        System.out.println("Начинает воин");

        System.out.println("Раунд: 1");
        warrior.attack(mage);
        mage.attack(warrior);
        warrior.block();

        System.out.println("Раунд: 2");
        warrior.attack(mage);
        mage.heal();
        mage.attack(warrior);

        System.out.println("Раунд: 3");
        warrior.attack(mage);
        mage.attack(warrior);
    }

    public static void startDelivery(Vehicle vehicle, String address) {
        vehicle.deliver(address);
    }
}