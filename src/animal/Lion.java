package animal;

public class Lion extends Animal {
    public Lion(int age) {
        super("Лев", age);
    }

    @Override
    public void makeSound() {
        System.out.println("Рычание!");
    }

    public void hunt() {
        System.out.println("Охота на антилопу");
    }
}
