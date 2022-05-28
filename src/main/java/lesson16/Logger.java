package lesson16;

import lesson16.dao.LogDAO;
import lesson16.model.Animal;
import lesson16.model.Log;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String FILE_NAME = "log.txt";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static BufferedWriter writer;

    private static final LogDAO ANIMAL_DAO = new LogDAO();


    public static void log(Animal animal) {
        logToFile(animal);
        logToDatabase(animal);
    }

    @SneakyThrows
    private static void logToFile(Animal animal) {
        final BufferedWriter writer = getWriter();
        final String date = LocalDateTime.now().format(FORMATTER);
        writer.write(String.format("[%s] %s%n", date, animal.toString()));
        writer.flush();
    }

    private static void logToDatabase(Animal animal) {
        final Log log = new Log();
        log.setAnimalName(animal.getName());
        log.setAnimalType(animal.getType().name());
        log.setAnimalState(animal.toString());
        ANIMAL_DAO.save(log);
    }

    @SneakyThrows
    private static BufferedWriter getWriter() {
        if (writer == null) {
            writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        }
        return writer;
    }
}
