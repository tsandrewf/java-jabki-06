package character;

public class Mage extends Character {
    private final int healthInitial;

    public Mage(int health) {
        super("Маг", health);
        this.healthInitial = health;
    }

    @Override
    public void attack(Character character) {
        if (!this.canAttack()) {
            return;
        }

        System.out.printf("%s: Огненный шар!\n", this.getName());
        character.takeDamage(1, this);
    }

    public void heal() {
        if (this.getHealth() <= 0) {
            System.out.printf("%s мертв, лечиться не может\n", this.getName());
            return;
        }

        this.takeDamage(-(this.healthInitial - this.getHealth()), this);
        System.out.printf("%s: Подлечился!\n", this.getName());
    }
}
