package lesson16.action;

import lesson16.Config;
import lesson16.model.Animal;

import java.util.Properties;

public class Cure implements Action {

    private static int cureCost;

    public Cure() {
        final Properties properties = Config.getProperties();
        cureCost = Integer.parseInt(properties.getProperty("cure.cost"));
    }

    @Override
    public void doAction(Animal animal) {
        if (!canCure(animal)) {
            animal.showState();
            return;
        }

        updateHungry(animal)
                .updateClear(animal)
                .updateHappy(animal)
                .updateIll(animal)
                .updateMany(animal);

        animal.showState();
    }

    private boolean canCure(Animal animal) {
        if (!animal.isIll()) {
            System.out.println("Животное не болеет. Пожалуй лечить не будем - пусть поживет!");
            return false;
        }

        if (animal.getMoney() < cureCost) {
            System.out.println("На лечение не хватает тугриков.");
            return false;
        }
        return true;
    }

    private Cure updateHungry(Animal animal) {
        double hungry = animal.getHungry();
        hungry = hungry > 70 ? 70 : hungry;
        animal.setHungry(hungry);
        return this;
    }

    private Cure updateClear(Animal animal) {
        double clear = animal.getClear();
        clear = clear < 80 ? 80 : clear;
        animal.setClear(clear);
        return this;
    }

    private Cure updateHappy(Animal animal) {
        double happy = animal.getHappy();
        happy = happy > 10 ? 10 : happy;
        animal.setHappy(happy);
        return this;
    }

    private Cure updateIll(Animal animal) {
        animal.setIll(false);
        System.out.println(animal.getName() + " вылечено.");
        return this;
    }

    private Cure updateMany(Animal animal) {
        animal.addMoney(-cureCost);
        return this;
    }
}
