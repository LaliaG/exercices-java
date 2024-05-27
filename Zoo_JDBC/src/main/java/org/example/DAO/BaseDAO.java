package org.example.DAO;

import org.example.Entity.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected String request;
    protected ResultSet resultSet;

    public BaseDAO() {

    }

    public abstract T save(T element) throws SQLException;

    public abstract boolean delete(T element) throws SQLException;

    public abstract T update(T element) throws SQLException;

    public abstract T get(int id) throws SQLException;

    public abstract List<T> get() throws SQLException;

    protected void close() throws SQLException {
        if (!resultSet.isClosed()) {
            resultSet.close();
        }
        if (!preparedStatement.isClosed()) {
            preparedStatement.close();
        }
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}























