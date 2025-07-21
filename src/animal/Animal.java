package animal;

public class Animal {
    private final String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Издает звук");
    }

    public  void eat() {
        System.out.printf("%s ест\n", this.name);
    }
}
