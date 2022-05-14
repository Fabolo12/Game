package lesson16.action;

import lesson16.model.Animal;
import lesson16.model.Present;

import static lesson16.Main.INPUT_SERVICES;

public class Shop implements Action {
    private static final PresentType[] PRESENT_TYPES = PresentType.values();
    @Override
    public void doAction(Animal animal) {
        int number;

        do {
            System.out.println("Выберите подарок: ");
            for (int i = 0; i < PRESENT_TYPES.length; i++) {
                System.out.printf("%d) за %d%n", i, PRESENT_TYPES[i].getCost());
            }
            System.out.printf("%d) Завершить покупки%n", PRESENT_TYPES.length);
            number = INPUT_SERVICES.getNumberFromUser();
        } while (number < 0 || number > PRESENT_TYPES.length);

        if (number < PRESENT_TYPES.length) {
            process(animal, number);
        } else {
            System.out.println("Жаль, что Вам ничего не подошло...");
        }
    }

    private void process(Animal animal, int number) {
        final PresentType presentType = PRESENT_TYPES[number];
        final int presentCost = presentType.getCost();
        if (presentCost > animal.getMoney()) {
            System.out.println("Вам не хватает денег :(");
            return;
        }
        animal.addMoney(-presentCost);
        animal.addPresent(new Present(presentType));
        animal.addHappy(presentType.getHappy());
        System.out.println(animal.getName() + " скупилось)");
        animal.showState();
    }
}
