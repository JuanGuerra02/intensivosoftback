package com.intensivo.softc.dao;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.dto.Producto;
import com.intensivo.softc.exception.DaoException;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class PrecioDao implements InPrecioDao {

    public void insert(Precio preciodto) throws DaoException {
        String INSERT = "INSERT INTO precio (nmprecio, sku, precio, fedesde, fehasta) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, preciodto.getNmprecio());
            statement.setString(2, preciodto.getPsku().getSku());
            statement.setDouble(3, preciodto.getPrecio());
            statement.setDate(4, preciodto.getFedesde());
            statement.setDate(5, preciodto.getFehasta());
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

    public void update(Precio preciodto) throws DaoException {
        String UPDATE = "UPDATE precio SET sku=?, precio=?, fedesde=? , fehasta=?  where nmprecio=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, preciodto.getPsku().getSku());
            statement.setDouble(2, preciodto.getPrecio());
            statement.setDate(3, preciodto.getFedesde());
            statement.setDate(4, preciodto.getFehasta());
            statement.setInt(5, preciodto.getNmprecio());
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

    public void delete(Precio preciodto) throws DaoException {
        String DELETE = "DELETE FROM precio where nmprecio=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, preciodto.getNmprecio());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }



    public Precio selectbyid(Precio preciodto) throws DaoException {
        Precio result =null;
        String SELECT="SELECT * FROM precio WHERE nmprecio = ?";
        PreparedStatement statement=null;
        ResultSet resultSet= null;
        Connection connection =Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, preciodto.getNmprecio());
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                result = new Precio();
                result.setNmprecio(resultSet.getInt("nmprecio"));

                Producto producto= new Producto();
                producto.setSku(resultSet.getString("sku"));
                result.setPsku(producto);

                result.setPrecio(resultSet.getDouble("precio"));
                result.setFedesde(resultSet.getDate("fedesde"));
                result.setFehasta(resultSet.getDate("fehasta"));
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

    public List<Precio> selectall() throws DaoException {
        List<Precio> list = new ArrayList<>();
        String SELECT = " SELECT * FROM precio";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Precio p = new Precio();
                p.setNmprecio(resultSet.getInt("nmprecio"));
                Producto producto= new Producto();
                producto.setSku(resultSet.getString("sku"));
                p.setPsku(producto);
                p.setPrecio(resultSet.getDouble("precio"));
                p.setFedesde(resultSet.getDate("fedesde"));
                p.setFehasta(resultSet.getDate("fehasta"));
                list.add(p);
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


