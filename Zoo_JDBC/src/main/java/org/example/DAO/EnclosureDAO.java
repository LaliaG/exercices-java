package org.example.DAO;

import org.example.Entity.Enclosure;

public class EnclosureDAO extends BaseDAO<Enclosure> {
    private CommandeFleuristeDAO commandeFleuristeDAO;
    public FleuristeDao(Connection connection) {
        super(connection);
        commandeFleuristeDAO = new CommandeFleuristeDAO(connection);
    }

    @Override
    public Fleuriste save(Fleuriste element) throws SQLException {
        try{
            request = "INSERT INTO fleuriste (name) VALUE (?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,element.getName());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(nbrow != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            _connection.commit();
            return element;
        }catch(SQLException e){
            _connection.rollback();
            return null;
        }
    }

    @Override
    public Fleuriste update(Fleuriste element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Fleuriste element) throws SQLException {
        return false;
    }

    @Override
    public Fleuriste get(int id) throws SQLException {
        request = "SELECT * FROM fleuriste WHERE id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return Fleuriste.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).commandes(commandeFleuristeDAO.getAllCommandeByFleuristeId(id)).build();
        }
        return null;
    }

    @Override
    public List<Fleuriste> get() throws SQLException {
        return null;
    }
}
