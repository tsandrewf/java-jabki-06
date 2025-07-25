package character;

public class Character {
    private final  String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void attack(Character character) {
        System.out.println("Атакую!");
        character.takeDamage(1, this);
    }

    public void takeDamage(int damage, Character fromWhom) {
        if (this.health == 0 && damage > 0) {
            System.out.printf("%s! Глумиться над трупом безнравственно!\n", fromWhom.getName());
            return;
        }

        this.health -= damage;

        if (this.health <= 0) {
            System.out.printf("%s: Прощайте друзья! :(\n", this.name);
            this.health = 0;
        } else if (this != fromWhom && damage < 0) {
            System.out.printf("%s: Спасибо, %s! Подлечил! :)\n", this.name, fromWhom.getName());
        } else if (this != fromWhom && damage == 0) {
            System.out.printf("%s: Атака от %s без ущерба! :)\n", this.name, fromWhom.getName());
        }
    }

    protected String getName() {
        return this.name;
    }

    protected int getHealth() {
        return this.health;
    }

    protected boolean canAttack() {
        if (this.health > 0) {
            return true;
        }

        System.out.printf("%s мертв, атаковать не может\n", this.name);
        return false;
    }
}
