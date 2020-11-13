package com.java02_oop.oop1_kelas_terbuka.lesson07_training;

class Player {
    String name;
    int hp;
    Armor armor;
    Weapon weapon;

    Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    void display() {
        System.out.printf("Player name : %s\n", this.name);
        this.armor.display();
        this.weapon.display();
    }

    void equipArmor(Armor armor) {
        this.armor = armor;
    }

    void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    void attack(Player opponent) {
        System.out.printf("Player %s attack %s with %s\n", this.name, opponent.name, this.weapon.name);
        opponent.hp -= this.weapon.attackPower;
    }

    void defence(Player opponent) {
        System.out.printf("%s defence attack from %s with %s\n", this.name, opponent.name, this.armor.name);
        System.out.printf("%s's HP : -%d by %s\n", this.name, opponent.weapon.attackPower, opponent.name);
        System.out.printf("%s's HP : %d\n\n", this.name, this.hp);
    }
}

class Weapon {
    String name;
    int attackPower;

    Weapon(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    void display() {
        System.out.println("== Weapon ==");
        System.out.printf("Name : %s\n Power: %d\n", this.name, this.attackPower);
    }
}

class Armor {
    String name;
    int defencePower;

    Armor(String name, int defencePower) {
        this.name = name;
        this.defencePower = defencePower;
    }

    void display() {
        System.out.println("=== Armor ===");
        System.out.printf("%s\n Shield : %d\n", this.name, this.defencePower);
    }
}

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Adnin", 100);
        Armor bajuBesi = new Armor("Baju Besi", 15);
        Weapon pedangBesi = new Weapon("Pedang", 20);
        player1.equipArmor(bajuBesi);
        player1.equipWeapon(pedangBesi);
        player1.display();

        System.out.println();

        Player player2 = new Player("Rifandi", 100);
        Armor bajuKulit = new Armor("Baju Kulit", 7);
        Weapon panah = new Weapon("Panah", 10);
        player2.equipArmor(bajuKulit);
        player2.equipWeapon(panah);
        player2.display();

        System.out.println();
        System.out.println();

        player1.attack(player2);
        player2.defence(player1);
        player2.attack(player1);
        player1.defence(player2);

        if (player1.hp < player2.hp) {
            System.out.printf("%s won!", player1.name);
        } else {
            System.out.printf("%s won!", player2.name);
        }
    }
}
