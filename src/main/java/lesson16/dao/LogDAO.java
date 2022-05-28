package lesson16.dao;

import lesson16.model.Animal;
import lesson16.model.Log;
import lesson16.model.NotImplementedException;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LogDAO extends AbstractDAO<Log> {

    @SneakyThrows
    @Override
    public Optional<Log> getById(String id) {
        final String sql = "select * from \"public\".\"Logs\" where id = ?";
        final PreparedStatement statement = getStatement(sql);
        statement.setString(1, id);
        final ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? Optional.of(Mapper.mapToObject(resultSet)) : Optional.empty();
    }

    @SneakyThrows
    @Override
    public List<Log> getAll() {
        final String sql = "select * from \"public\".\"Logs\" order by timestamp";
        final PreparedStatement statement = getStatement(sql);
        final ResultSet resultSet = statement.executeQuery();
        final List<Log> logs = new LinkedList<>();

        while (resultSet.next()) {
            final Log log = Mapper.mapToObject(resultSet);
            logs.add(log);
        }

        return logs;
    }

    @SneakyThrows
    @Override
    public void save(Log value) {
        final String sql = "insert into \"public\".\"Logs\" " +
                "(\"id\", \"animal_name\", \"animal_type\", \"animal_state\", \"timestamp\")\n" +
                "values (?, ?, ?, ?, ?)";
        final PreparedStatement statement = getStatement(sql);
        statement.setString(1, String.valueOf(UUID.randomUUID()));
        statement.setString(2, value.getAnimalName());
        statement.setString(3, value.getAnimalType());
        statement.setString(4, value.getAnimalState());
        statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(Log value) {
        throw new NotImplementedException();
    }

    static class Mapper {
        @SneakyThrows
        public static Log mapToObject(final ResultSet resultSet) {
            final Log log = new Log();
            log.setId(resultSet.getString("id"));
            log.setAnimalName(resultSet.getString("animal_name"));
            log.setAnimalType(resultSet.getString("animal_type"));
            log.setAnimalState(resultSet.getString("animal_state"));
            log.setTimestamp(resultSet.getTimestamp("timestamp").toLocalDateTime());
            return log;
        }
    }
}
