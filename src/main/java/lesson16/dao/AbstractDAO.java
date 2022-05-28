package lesson16.dao;

import lesson16.Config;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public abstract class AbstractDAO<T> {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    public AbstractDAO() {
        final Properties properties = Config.getProperties();
        URL = properties.getProperty("database.url");
        USER = properties.getProperty("database.user");
        PASSWORD = properties.getProperty("database.password");
    }

    @SneakyThrows
    protected PreparedStatement getStatement(final String sql) {
        final Connection connection = getConnection();
        return connection.prepareStatement(sql);
    }

    @SneakyThrows
    private Connection getConnection() {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public abstract Optional<T> getById(String id);
    public abstract List<T> getAll();
    public abstract void save(T value);
    public abstract void delete(T value);
}
