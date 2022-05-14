package lesson16.action;

import lombok.Getter;

@Getter
public enum PresentType {
    ONE(100, 20),
    TWO(150, 25),
    THREE(200, 30);

    private final int cost;
    private final int happy;

    PresentType(int cost, int happy) {
        this.cost = cost;
        this.happy = happy;
    }
}
