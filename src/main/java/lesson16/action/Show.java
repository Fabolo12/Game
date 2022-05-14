package lesson16.action;

import lesson16.model.Animal;

public class Show implements Action{
    @Override
    public void doAction(Animal animal) {
        animal.showState();
    }
}
