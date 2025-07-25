package character;

public class Warrior extends Character {
    public Warrior(int health) {
        super("Воин", health);
    }

    @Override
    public void attack(Character character) {
        if (!this.canAttack()) {
            return;
        }

        System.out.printf("%s: Мечом в лицо!\n", this.getName());
        character.takeDamage(1, this);
    }

    public void block() {
        this.takeDamage(-1, this);
        System.out.printf("%s: Блокировал!\n", this.getName());
    }
}
