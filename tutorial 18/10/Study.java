package study;

import java.util.Scanner;
import java.util.Random;

public class Study {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("========================================");
        System.out.println("      WELCOME TO THE REALM RPG         ");
        System.out.println("========================================\n");

        // 1. Character Creation
        System.out.print("Enter your hero's name: ");
        String playerName = input.next();

        System.out.println("\nChoose your class:");
        System.out.println("1. Heavy Knight  (+Defense & High HP)");
        System.out.println("2. Mage          (+Mana & High Magic)");
        System.out.println("3. Sword         (+Strength & High Attack)");
        System.out.print("Selection (Type 1-3 or Class Name): ");

        String classInput = input.next();
        String playerRole = "Sword"; // Default fallback

        // Check if they typed numbers or text!
        if (classInput.equals("1") || classInput.equalsIgnoreCase("Knight") || classInput.equalsIgnoreCase("Heavy")) {
            playerRole = "Heavy Knight";
        } else if (classInput.equals("2") || classInput.equalsIgnoreCase("Mage")) {
            playerRole = "Mage";
        } else if (classInput.equals("3") || classInput.equalsIgnoreCase("Sword")) {
            playerRole = "Sword";
        } else {
            playerRole = classInput; // Allows custom classes too!
        }
        // Build player hero with class stat modifiers
        Hero player = new Hero(playerName, playerRole);
        System.out.println("\nHero initialized successfully!");
        player.showStats();

        // Game Loop State Variables
        int currentLocation = 1; // 1: Village, 2: Guild, 3: Forest, 4: Dark Forest
        boolean playing = true;

        // 2. Main Game Loop
        while (playing) {
            System.out.println("\n----------------------------------------");
            System.out.println("CURRENT LOCATION: " + getLocationName(currentLocation));
            System.out.println("----------------------------------------");
            System.out.println("1. Explore / Search for Monsters");
            System.out.println("2. Fast Travel (Teleport)");
            System.out.println("3. View Hero Stats & Allocate Points");
            System.out.println("4. Quit Game");
            System.out.print("Choose action: ");

            int action = input.nextInt();

            if (action == 1) {
                if (currentLocation == 2) {
                    System.out.println("🏛️ You are in the Guild. It's a safe zone! Cash out resources or heal here.");
                } else {
                    // Spawn monster based on weighted probabilities for current zone
                    GameCharacter monster = spawnZoneMonster(currentLocation, rand);
                    monster.spawnAnnouncement();

                    // Simple combat iteration
                    while (player.health > 0 && monster.health > 0) {
                        System.out.println("\n[Combat Menu] 1. Attack | 2. Heal | 3. Run");
                        System.out.print("Choice: ");
                        int combatChoice = input.nextInt();

                        if (combatChoice == 1) {
                            player.attack(monster);
                            if (monster.health > 0) {
                                monster.attackHero(player);
                            }
                        } else if (combatChoice == 2) {
                            player.heal();
                            monster.attackHero(player);
                        } else {
                            System.out.println("🏃 You fled back to safety!");
                            break;
                        }
                    }

                    // Check battle victory
                    if (monster.health <= 0) {
                        System.out.println("🎉 You defeated " + monster.name + "!");
                        int earnedXp = monster.level * 25;
                        player.gainXp(earnedXp, input);
                    } else if (player.health <= 0) {
                        System.out.println("☠️ You were defeated! Game Over.");
                        playing = false;
                    }
                }
            } else if (action == 2) {
                // Teleport Menu
                System.out.println("\n--- TELEPORT LOCATIONS ---");
                System.out.println("1. Village (Farmer's Place - Easy)");
                System.out.println("2. Adventurer Guild (Safe Zone / Cash Out)");
                System.out.println("3. Forest (Moderate Danger)");
                System.out.println("4. Dark Forest (Stormy / High Danger)");
                System.out.print("Select Destination (1-4): ");
                currentLocation = input.nextInt();
                System.out.println("✨ Teleported to " + getLocationName(currentLocation) + "!");
            } else if (action == 3) {
                player.showStats();
                player.allocateStatPoints(input);
            } else if (action == 4) {
                playing = false;
                System.out.println("Thanks for playing!");
            }
        }
    }

    // Helper method to resolve location names
    public static String getLocationName(int loc) {
        switch (loc) {
            case 1: return "Village (Farmer's Place)";
            case 2: return "Adventurer Guild (Safe Zone)";
            case 3: return "Deep Forest";
            case 4: return "Dark Forest ⛈️ (Thunderstorm)";
            default: return "Unknown Land";
        }
    }

    // Weighted spawn logic based on location
    public static GameCharacter spawnZoneMonster(int location, Random rand) {
        int roll = rand.nextInt(100) + 1; // 1 to 100

        String race, kind;
        int monsterLevel;

        if (location == 1) { // Village
            monsterLevel = rand.nextInt(2) + 1; // Level 1-2
            if (roll <= 70) { race = "Slime"; kind = "Green Blob"; }
            else if (roll <= 95) { race = "Goblin"; kind = "Scout"; }
            else { race = "Orc"; kind = "Wanderer"; }
        } else if (location == 3) { // Forest
            monsterLevel = rand.nextInt(3) + 2; // Level 2-4
            if (roll <= 30) { race = "Slime"; kind = "Acid Blob"; }
            else if (roll <= 80) { race = "Goblin"; kind = "Warrior"; }
            else { race = "Orc"; kind = "Brute"; }
        } else { // Dark Forest (Stormy)
            monsterLevel = rand.nextInt(4) + 4; // Level 4-7
            if (roll <= 10) { race = "Slime"; kind = "Elder Blob"; }
            else if (roll <= 40) { race = "Goblin"; kind = "Berserker"; }
            else { race = "Orc"; kind = "Warlord"; }
        }

        return new GameCharacter(race + " " + kind, race, kind, monsterLevel);
    }
}

// Player Class inheriting / extending base stats
class Hero {
    String name;
    String role;
    int level = 1;
    int xp = 0;
    int xpToLevel = 50;

    int maxHealth;
    int health;
    int strength;
    int mana;
    int defense;
    int unusedPoints = 0;

    public Hero(String name, String role) {
        this.name = name;
        this.role = role;

        // Base attributes
        this.maxHealth = 100;
        this.strength = 10;
        this.mana = 20;
        this.defense = 5;

        // Class Specific Modifiers
        if (role.equalsIgnoreCase("Heavy Knight")) {
            this.maxHealth += 40;
            this.defense += 8;
        } else if (role.equalsIgnoreCase("Mage")) {
            this.mana += 40;
            this.strength += 2;
        } else if (role.equalsIgnoreCase("Sword")) {
            this.strength += 10;
            this.maxHealth += 15;
        }
        this.health = this.maxHealth;
    }

    public void attack(GameCharacter target) {
        int damage = this.strength + 10 - target.level;
        if (damage < 5) damage = 5; // Minimum damage floor
        System.out.println("⚔️ " + name + " attacks " + target.name + " for " + damage + " damage!");
        target.health -= damage;
    }

    public void heal() {
        int amount = 25 + (mana / 2);
        this.health = Math.min(this.maxHealth, this.health + amount);
        System.out.println("✨ " + name + " healed for " + amount + " HP! (Current HP: " + health + "/" + maxHealth + ")");
    }

    public void gainXp(int amount, Scanner input) {
        this.xp += amount;
        System.out.println("⭐ Gained " + amount + " XP! (" + xp + "/" + xpToLevel + ")");
        if (this.xp >= this.xpToLevel) {
            this.level++;
            this.xp -= this.xpToLevel;
            this.xpToLevel += 40; // Escalating XP requirement
            this.unusedPoints += 2; // Grant 2 stat points
            System.out.println("\n🎊 LEVEL UP! You reached Level " + level + "!");
            System.out.println("+2 Stat Points available to allocate!");
            allocateStatPoints(input);
        }
    }

    public void allocateStatPoints(Scanner input) {
        while (unusedPoints > 0) {
            System.out.println("\nYou have " + unusedPoints + " Stat Point(s) left.");
            System.out.println("1. Strength (+2 Atk Power)");
            System.out.println("2. Mana     (+10 MP / Healing Power)");
            System.out.println("3. Max HP   (+15 Max Health)");
            System.out.println("4. Defense  (+2 Damage Reduction)");
            System.out.print("Choose stat to upgrade (1-4): ");
            int choice = input.nextInt();

            if (choice == 1) { strength += 2; unusedPoints--; }
            else if (choice == 2) { mana += 10; unusedPoints--; }
            else if (choice == 3) { maxHealth += 15; health += 15; unusedPoints--; }
            else if (choice == 4) { defense += 2; unusedPoints--; }
        }
    }

    public void showStats() {
        System.out.println("\n========== HERO STATS ==========");
        System.out.println("Name    : " + name + " (" + role + ")");
        System.out.println("Level   : " + level + " (XP: " + xp + "/" + xpToLevel + ")");
        System.out.println("HP      : " + health + "/" + maxHealth);
        System.out.println("Strength: " + strength);
        System.out.println("Mana    : " + mana);
        System.out.println("Defense : " + defense);
        System.out.println("Stat Pts: " + unusedPoints);
        System.out.println("================================\n");
    }
}

// Monster Blueprint
class GameCharacter {
    String name;
    String race;
    String kind;
    int level;
    int health;

    public GameCharacter(String name, String race, String kind, int level) {
        this.name = name;
        this.race = race;
        this.kind = kind;
        this.level = level;
        this.health = 25 + (level * 20);
    }

    public void spawnAnnouncement() {
        System.out.println("\n⚠️ A wild monster appears! ⚠️");
        System.out.println("----------------------------------------");
        System.out.println("Name   : " + name);
        System.out.println("Race   : " + race);
        System.out.println("Kind   : " + kind);
        System.out.println("HP     : " + health);
        System.out.println("Level  : " + level);
        System.out.println("----------------------------------------");
    }

    public void attackHero(Hero target) {
        int baseDamage = 8 + (level * 4);
        int actualDamage = baseDamage - target.defense;
        if (actualDamage < 3) actualDamage = 3; // Minimum damage floor

        System.out.println("👹 " + name + " attacks " + target.name + " for " + actualDamage + " damage!");
        target.health -= actualDamage;
        System.out.println(target.name + " HP: " + target.health + "/" + target.maxHealth);
    }
}