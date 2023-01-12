package com.intensivo.softc.dao;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.*;
import com.intensivo.softc.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FacturaDao implements InFacturaDao {

    public void insert(Factura facturadto) throws DaoException {
        String INSERT = "INSERT INTO factura (nmfactura, cdfactura, fefactura, nmvendedor, nmcliente) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, facturadto.getNmfactura());
            statement.setString(2, facturadto.getCdfactura());
            statement.setDate(3, facturadto.getFefactura());
            statement.setInt(4, facturadto.getFnmvendedor().getNmvendedor());
            statement.setInt(5, facturadto.getFnmcliente().getNmcliente());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                }
            }
        }


    public void update(Factura facturadto) throws DaoException {
        String UPDATE = "UPDATE factura SET cdfactura=?, fefactura=?, nmvendedor=?, nmcliente=? where nmfactura";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, facturadto.getCdfactura());
            statement.setDate(2, facturadto.getFefactura());
            statement.setInt(3, facturadto.getFnmvendedor().getNmvendedor());
            statement.setInt(4, facturadto.getFnmcliente().getNmcliente());
            statement.setInt(5, facturadto.getNmfactura());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void delete(Factura facturadto) throws DaoException {
        String DELETE = "DELETE FROM  factura where nmfactura =?)";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, facturadto.getNmfactura());
           statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Factura selectbyid(Factura facturadto) throws DaoException {
        Factura result =null;
        String SELECT="SELECT * FROM factura WHERE nmfactura = ?";
        PreparedStatement statement=null;
        ResultSet resultSet= null;
        Connection connection =Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, facturadto.getNmfactura());
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                result = new Factura();
                result.setNmfactura(resultSet.getInt("nmfactura"));
                result.setCdfactura(resultSet.getString("cdfactura"));
                result.setFefactura(resultSet.getDate("fefactura"));

                Vendedor vendedor = new Vendedor();
                vendedor.setNmvendedor(resultSet.getInt("nmvendedor"));
                result.setFnmvendedor(vendedor);

                Cliente cliente = new Cliente();
                cliente.setNmcliente(resultSet.getInt("nmcliente"));
                result.setFnmcliente(cliente);
            }
        }catch (Exception ex){
            throw new DaoException(ex);
        }finally {
            try {

                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public List<Factura> selectall() throws DaoException {
        List<Factura> list = new ArrayList<>();
        String SELECT = " SELECT * FROM factura";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Factura factura = new Factura();
                factura.setNmfactura(resultSet.getInt("nmfactura"));
                factura.setCdfactura(resultSet.getString("cdfactura"));
                factura.setFefactura(resultSet.getDate("fefactura"));

                Vendedor vendedor = new Vendedor();
                vendedor.setNmvendedor(resultSet.getInt("nmvendedor"));
                factura.setFnmvendedor(vendedor);

                Cliente cliente = new Cliente();
                cliente.setNmcliente(resultSet.getInt("nmcliente"));
                factura.setFnmcliente(cliente);
                list.add(factura);
            }
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

}
