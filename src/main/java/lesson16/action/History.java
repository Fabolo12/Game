package lesson16.action;

import lesson16.dao.LogDAO;
import lesson16.model.Animal;

public class History implements Action {
    private static LogDAO animalDAO;

    public History() {
        animalDAO = new LogDAO();
    }

    @Override
    public void doAction(Animal animal) {
        animalDAO.getAll().forEach(System.out::println);
    }
}
