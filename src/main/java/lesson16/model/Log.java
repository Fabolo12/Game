package lesson16.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Log {
    private String id;
    private String animalName;
    private String animalType;
    private String animalState;
    private LocalDateTime timestamp;
}
