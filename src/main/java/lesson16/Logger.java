package lesson16;

import lesson16.model.Animal;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String FILE_NAME = "log.txt";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static BufferedWriter writer;

    @SneakyThrows
    public static void log(Animal animal) {
        final BufferedWriter writer = getWriter();
        final String date = LocalDateTime.now().format(FORMATTER);
        writer.write(String.format("[%s] %s%n", date, animal.toString()));
        writer.flush();
    }

    @SneakyThrows
    private static BufferedWriter getWriter() {
        if (writer == null) {
            writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        }
        return writer;
    }
}
