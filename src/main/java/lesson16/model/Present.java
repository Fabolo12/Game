package lesson16.model;

import lesson16.action.PresentType;
import lombok.Getter;

import java.util.Random;

@Getter
public class Present {
    final private static Random random = new Random();
    private final String name;
    private final PresentType type;

    public Present(PresentType type) {
        this.name = "Present " + random.nextInt();
        this.type = type;
    }
}
