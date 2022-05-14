package lesson16.model;

import lesson16.Config;
import lesson16.Logger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

@Getter
@Setter
@ToString
public class Animal {
    private final String name;

    private final AnimalType type;

    private int age;

    private double hungry;

    private double money;

    private double clear;

    private double happy;

    private boolean ill;

    private final ArrayList<Present> presents;

    private int gameCount;

    private int workCount;

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
        initBaseValues();
        this.ill = false;
        presents = new ArrayList<>();
        this.gameCount = 0;
        this.workCount = 0;
    }

    private void initBaseValues() {
        final Properties properties = Config.getProperties();
        this.age = Integer.parseInt(properties.getProperty("age"));
        this.hungry = Double.parseDouble(properties.getProperty("hungry"));
        this.money = Double.parseDouble(properties.getProperty("money"));
        this.clear = Double.parseDouble(properties.getProperty("clear"));
        this.happy = Double.parseDouble(properties.getProperty("happy"));
    }

    public void addHungry(double value) {
        hungry += countValue(value);
    }

    public void addClear(double value) {
        clear += countValue(value);
    }

    public void addHappy(double value) {
        happy += countValue(value);
    }

    public void increaseMoney(int min, int max) {
        money += (min + Math.random() * (max - min + 1));
    }

    public void addMoney(double value) {
        money += value;
    }

    public void increaseAge() {
        age++;
    }

    public void addPresent(Present present) {
        presents.add(present);
    }

    public void increaseGame() {
        gameCount++;
    }

    public void increaseWork() {
        workCount++;
    }

    public double countValue(double value) {
        double multiplier = 1;
        if (ill) {
            multiplier *= 2.0;
        }
        if (hungry < 50) {
            multiplier *= 1.5;
        }
        if (happy < 10) {
            multiplier *= 1.2;
        }
        return value * multiplier;
    }

    public void toSeek() {
        final int probability = 10 * (clear < 20 ? 3 : 1);
        if (probability > (Math.random() * 101)) {
            ill = true;
        }
    }

    public void showState() {
        System.out.printf("Возраст: %d; Сытость: %.2f; Деньги: %.2f; Чистота: %.2f; Счастье: %.2f; Подарков: %d%n", age, hungry,
                money, clear, happy, presents.size());
        if (ill) {
            System.out.println("Животное заболело!");
        }
        Logger.log(this);
    }

}
