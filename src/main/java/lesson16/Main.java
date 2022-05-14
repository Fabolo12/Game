package lesson16;

import lesson16.action.ActionType;
import lesson16.model.Animal;
import lesson16.model.AnimalType;
import lesson16.user.UserInputServices;

public class Main {
    public static final UserInputServices INPUT_SERVICES = new UserInputServices();

    public static void main(String[] args) {
        final AnimalType animalType = getAnimalType();
        final String animalName = getAnimalName();
        final Animal animal = new Animal(animalName, animalType);
        while (true) {
            doAction(animal);
        }
    }

    private static void doAction(final Animal animal) {
        final ActionType[] values = ActionType.values();
        int number = -1;
        do {
            System.out.println("Выберите ваше действие: ");
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i, values[i]);
            }
            number = INPUT_SERVICES.getNumberFromUser();
        } while (number < 0 || number >= values.length);
        final ActionType action = values[number];
        action.doAction(animal);
    }

    private static AnimalType getAnimalType() {
        final AnimalType[] values = AnimalType.values();
        int number = -1;
        do {
            System.out.println("Выберите ваше животное: ");
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i, values[i]);
            }
            number = INPUT_SERVICES.getNumberFromUser();
        } while (number < 0 || number >= values.length);
        return values[number];
    }

    private static String getAnimalName() {
        String name;
        do {
            System.out.println("Выберите имя животного (min: 3; max 20): ");
            name = INPUT_SERVICES.getStringFromUser();
        } while (name.length() < 3 || name.length() > 20);
        return name;
    }
}
