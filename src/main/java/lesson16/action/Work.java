package lesson16.action;

import lesson16.Config;
import lesson16.model.Animal;

public class Work implements Action {
    @Override
    public void doAction(Animal animal) {
        if (animal.getAge() < 5) {
            System.out.println(animal.getName() + " еще не доросло)");
            return;
        }
        if (animal.getHappy() < 20) {
            System.out.println("Друзья мои, я опечален... Нехо работать.");
        }
        animal.increaseWork();
        if (animal.getWorkCount() % 6 == 0) {
            animal.increaseAge();
        }
        animal.addHungry(-4);
        animal.increaseMoney(5, 20);
        animal.addHappy(-2);
        animal.toSeek();
        System.out.println(animal.getName() + " поработало.)");
        animal.showState();
    }
}
