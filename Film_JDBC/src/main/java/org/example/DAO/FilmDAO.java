package org.example.DAO;

import org.example.Entity.Film;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO extends BaseDAO<Film> {


    public FilmDAO (Connection connection){
        super(connection);
    }

    @Override
    public Film save(Film element) throws SQLException {


        try {
            request = "INSERT INTO film (titre,realisateur,date_de_sortie,genre) VALUE (?,?,?,?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, element.getTitre());
            preparedStatement.setString(2, element.getRealisateur());
            preparedStatement.setDate(3, element.getDate.valueOf(dateDeSortie));
            preparedStatement.setString(4, element.getGenre());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            Film film = null;
            if (resultSet.next()) {
                film = Film.builder().titre(element.getTitre()).realisateur(element.getRealisateur()).dateSortie(element.getDate.valueOf(dateDeSortie)).genre(element.getGenre()).id_film(resultSet.getInt(1)).build();
            }
            if (nbrow != 1) {
                _connection.rollback();
            }
            _connection.commit();
            return film;
        } catch (SQLException e) {
            _connection.rollback();
            return null;
        }

    }

    @Override
    public Film update(Film element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Film element) throws SQLException {
        return false;
    }


    public Film get(int id) throws SQLException {
        request = "SELECT * FROM film WHERE id = ?";
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return  Film.builder().titre(resultSet.getString("titre"))
                    .realisateur(resultSet.getString("realisateur"))
                    .dateSortie(resultSet.getDate("date_de_sortie").toLocalDate())
                    .genre(resultSet.getString("genre")).build();
        }

        return null;
    }

    public List<Film> get() throws SQLException {
        List<Film> films = new ArrayList<>();
        request = "SELECT * FROM film";
        preparedStatement = connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            films.add(Film.builder().titre(resultSet.getString("titre"))
                    .realisateur(resultSet.getString("realisateur"))
                    .dateSortie(resultSet.getDate("date_de_sortie").toLocalDate())
                    .genre(resultSet.getString("genre"))
                    .build());
        }
        return films;
    }

}
