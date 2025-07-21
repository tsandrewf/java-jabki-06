package animal;

public class Parrot extends Animal {
    public Parrot(int age) {
        super("Попугай", age);
    }

    @Override
    public void makeSound() {
        System.out.println("Попугай повторяет: Привет!");
    }
}
