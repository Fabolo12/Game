package lesson16.action;

import lesson16.model.Animal;

public class Food implements Action {
    @Override
    public void doAction(Animal animal) {
        animal.addHungry(5);
        animal.addClear(-2);
        System.out.println(animal.getName() + " покормлено.");
        animal.showState();
    }
}
