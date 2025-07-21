import character.Mage;
import character.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @Order(1)
    void accountTest() {
        Account account = new Account();

        account.displayInfo();
        Assertions.assertEquals("Баланс счета 1: 0.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        account.deposit(1000.0);
        account.displayInfo();
        Assertions.assertEquals("Баланс счета 1: 1000.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        account.deposit(-100.0);
        Assertions.assertEquals("Сумма пополнения (-100.0) должна быть больше нуля", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        account.withdraw(300.0);
        account.displayInfo();
        Assertions.assertEquals("Баланс счета 1: 700.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        account.withdraw(800.0);
        Assertions.assertEquals("Сумма снятия (800.0) должна быть больше баланса (700.0)", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        account.withdraw(-200.0);
        Assertions.assertEquals("Сумма снятия (-200.0) должна быть больше нуля", outputStreamCaptor.toString().trim());
    }

    @Test
    @Order(2)
    void savingsAccountTest() {
        SavingsAccount savingsAccount = new SavingsAccount();

        outputStreamCaptor.reset();
        savingsAccount.displayInfo();
        Assertions.assertEquals("Баланс сберегательного счета 2: 0.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        savingsAccount.deposit(1000.0);
        savingsAccount.displayInfo();
        Assertions.assertEquals("Баланс сберегательного счета 2: 1000.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        savingsAccount.applyInterest();
        savingsAccount.displayInfo();
        Assertions.assertEquals("Баланс сберегательного счета 2: 1200.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        savingsAccount.withdraw(1100);
        Assertions.assertEquals("Сумма снятия (1100.0) не должна превышать допустимый лимит (1000.0)", outputStreamCaptor.toString().trim());
    }

    @Test
    @Order(3)
    void creditAccountTest() {
        CreditAccount creditAccount = new CreditAccount();

        creditAccount.displayInfo();
        Assertions.assertEquals("Баланс счета 3: 0.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        creditAccount.withdraw(60000.0);
        creditAccount.displayInfo();
        Assertions.assertEquals("Баланс счета 3: -60000.0", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        creditAccount.withdraw(50000.0);
        Assertions.assertEquals("Баланс счета 3 после снятия (-110000.0) не должен превышать кредитный лимит (100000.0)", outputStreamCaptor.toString().trim());
    }

    @Test
    void vehicleTest() {
        outputStreamCaptor.reset();
        Vehicle vehicle = new Vehicle(1000, 2500);
        vehicle.deliver("Владивосток");
        Assertions.assertEquals("Доставка в Владивосток", outputStreamCaptor.toString().trim());
    }

    @Test
    void truckTest() {
        outputStreamCaptor.reset();
        Truck truck = new Truck(100, 15000);
        truck.deliver("Камчатка");
        Assertions.assertEquals("Грузовик загружен. Доставка в Камчатка", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        Main.startDelivery(truck, "Анадырь");
        Assertions.assertEquals("Грузовик загружен. Доставка в Анадырь", outputStreamCaptor.toString().trim());
    }

    @Test
    void droneTest() {
        outputStreamCaptor.reset();
        Drone drone = new Drone(250, 150);
        drone.deliver("Подальше");
        Assertions.assertEquals("Дрон взлетел. Доставка в Подальше", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        Main.startDelivery(drone, "Еще дальше");
        Assertions.assertEquals("Дрон взлетел. Доставка в Еще дальше", outputStreamCaptor.toString().trim());
    }

    @Test
    void animalTest() {
        Animal animal = new Animal("Корова", 2);

        outputStreamCaptor.reset();
        animal.makeSound();
        Assertions.assertEquals("Издает звук", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        animal.eat();
        Assertions.assertEquals("Корова ест", outputStreamCaptor.toString().trim());
    }

    @Test
    void lionTest() {
        Lion lion = new Lion(2);

        outputStreamCaptor.reset();
        lion.makeSound();
        Assertions.assertEquals("Рычание!", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        lion.eat();
        Assertions.assertEquals("Лев ест", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        lion.hunt();
        Assertions.assertEquals("Охота на антилопу", outputStreamCaptor.toString().trim());
    }

    @Test
    void parrotTest() {
        Parrot parrot = new Parrot( 200);

        outputStreamCaptor.reset();
        parrot.makeSound();
        Assertions.assertEquals("Попугай повторяет: Привет!", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        parrot.eat();
        Assertions.assertEquals("Попугай ест", outputStreamCaptor.toString().trim());
    }
    @Test
    void aviaryTest() {
        List<Animal> aviary = new ArrayList<>();
        aviary.add(new Parrot(120));
        aviary.add(new Animal("Какое-то животное", 1));
        aviary.add(new Lion(3));

        outputStreamCaptor.reset();
        for(Animal aviaryAnimal: aviary) {
            aviaryAnimal.makeSound();
        }
        Assertions.assertEquals("Попугай повторяет: Привет!\r\nИздает звук\r\nРычание!", outputStreamCaptor.toString().trim());
    }

    @Test
    void characterTest() {
        Warrior warrior = new Warrior(3);
        Mage mage = new Mage(2);

        outputStreamCaptor.reset();
        warrior.attack(mage);
        mage.attack(warrior);
        warrior.block();
        Assertions.assertEquals("Воин: Мечом в лицо!\nМаг: Огненный шар!\nВоин: Блокировал!", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        warrior.attack(mage);
        mage.heal();
        mage.attack(warrior);
        Assertions.assertEquals("Воин: Мечом в лицо!\nМаг: Прощайте друзья! :(\nМаг мертв, лечиться не может\nМаг мертв, атаковать не может", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        warrior.attack(mage);
        mage.attack(warrior);
        Assertions.assertEquals("Воин: Мечом в лицо!\nВоин! Глумиться над трупом безнравственно!\nМаг мертв, атаковать не может", outputStreamCaptor.toString().trim());
    }
}