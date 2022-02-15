package model.dao.impl;

import db.JDBCConnectionManager;
import util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dao.IFornecedorDAO;
import model.domain.Fornecedor;

public class FornecedorDAO implements IFornecedorDAO {
    
    @Override
    public boolean editar(Fornecedor fornecedor) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE fornecedor "
                    + " SET nomeFantasia = ?,"
                    + "razaoSocial = ?,"
                    + "CNPJ = ?,"
                    + "cidade = ?,"
                    + "regiao = ?"
                    + " WHERE fornecedorID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, fornecedor.getNomeFantasia());
            statement.setString(2, fornecedor.getRazaoSocial());
            statement.setString(3, fornecedor.getCNPJ());
            statement.setString(4, fornecedor.getCidade());
            statement.setString(5, fornecedor.getRegiao());
            statement.setInt(6, fornecedor.getFornecedorID());

            statement.execute();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
        return true;
    }

    
    @Override
    public Fornecedor consultarPorCodigo(Integer cod) throws PersistenciaException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM fornecedor WHERE fornecedorID = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod);
            ResultSet rs = pstmt.executeQuery();

            Fornecedor fornecedor = null;
            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setFornecedorID(rs.getInt("fornecedorID"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCNPJ(rs.getString("CNPJ"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setRegiao(rs.getString("regiao"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return fornecedor;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
    
    @Override
    public List<Fornecedor> exibirTodos() throws PersistenciaException {

        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM fornecedor";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setFornecedorID(resultSet.getInt("fornecedorID"));
                fornecedor.setNomeFantasia(resultSet.getString("nomeFantasia"));
                fornecedor.setRazaoSocial(resultSet.getString("razaoSocial"));
                fornecedor.setCNPJ(resultSet.getString("CNPJ"));
                fornecedor.setCidade(resultSet.getString("cidade"));
                fornecedor.setRegiao(resultSet.getString("regiao"));

                fornecedorList.add(fornecedor);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
        return fornecedorList;
    }

    @Override
    public boolean adicionar(Fornecedor fornecedor) throws PersistenciaException {

        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO fornecedor (nomeFantasia, razaoSocial, CNPJ, cidade, regiao) " + "VALUES(?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, fornecedor.getNomeFantasia());
            statement.setString(2, fornecedor.getRazaoSocial());
            statement.setString(3, fornecedor.getCNPJ());
            statement.setString(4, fornecedor.getCidade());
            statement.setString(5, fornecedor.getRegiao());
            
            statement.executeUpdate();
            connection.close();

            
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
        return true;
    }
    @Override
    public boolean excluir(Integer id) throws PersistenciaException {

        try{
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM fornecedor WHERE fornecedorID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
        }catch(Exception e){
                e.printStackTrace();
                throw new PersistenciaException(e.getMessage(), e);
        }
        return true;
    }

}
