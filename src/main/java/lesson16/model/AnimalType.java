package lesson16.model;

public enum AnimalType {
    DEER("Олень"),
    LION("Лев"),
    CAT("Кот"),
    DOG("Собака");

    private final String name;

    AnimalType(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
