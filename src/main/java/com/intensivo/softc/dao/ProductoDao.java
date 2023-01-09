package com.intensivo.softc.dao;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.exception.DaoException;
import com.intensivo.softc.dto.Producto;
import org.springframework.stereotype.Component;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoDao implements InProductoDao {

    public void insert(Producto Pdto) throws DaoException {

        String INSERT = "INSERT INTO productos (sku,dsproducto) value (?,?)";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, Pdto.getSku());
            statement.setString(2, Pdto.getDsproducto());
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


    public void delete(Producto Pdto) throws DaoException {
        String DELETE = "DELETE FROM productos where sku=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setString(1, Pdto.getSku());
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

    public void update(Producto Pdto) throws DaoException {
        String UPDATE = "UPDATE productos SET  dsproducto=? where sku=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, Pdto.getDsproducto());
            statement.setString(2, Pdto.getSku());
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

    public Producto selectbyid(Producto Pdto) throws DaoException {
        Producto result = null;
        String SELECT = " SELECT sku, dsproducto from productos where sku=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, Pdto.getSku());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new Producto();
                result.setSku(resultSet.getString("sku"));
                result.setDsproducto(resultSet.getString("dsproducto"));
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
        return result;
    }

    public List<Producto> selectall() throws DaoException {
        List<Producto> list = new ArrayList<>();
        String SELECT = " SELECT sku, dsproducto FROM productos";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Producto p = new Producto();
                p.setSku(resultSet.getString("sku"));
                p.setDsproducto(resultSet.getString("dsproducto"));
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
