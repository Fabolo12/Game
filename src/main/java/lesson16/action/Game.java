package lesson16.action;

import lesson16.model.Animal;

public class Game implements Action {
    @Override
    public void doAction(Animal animal) {
        animal.addHungry(-3);
        animal.addHappy(6);
        animal.increaseGame();
        if (animal.getGameCount() % 5 == 0) {
            animal.increaseAge();
        }
        animal.increaseMoney(1, 10);
        animal.toSeek();
        System.out.println(animal.getName() + " поиграло:)");
        animal.showState();
    }
}
