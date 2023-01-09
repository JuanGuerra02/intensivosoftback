package com.intensivo.softc.dao;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.DaoException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao implements InVendedorDao{


    public void insert(Vendedor Vdto) throws DaoException {
        String INSERT = " INSERT INTO vendedor (nmvendedor,documento,dsnombres,desapellidos,dsdireccion) value (?,?,?,?,?) ";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1,Vdto.getNmvendedor());
            statement.setString(2,Vdto.getDocumento());
            statement.setString(3,Vdto.getDsnombres());
            statement.setString(4,Vdto.getDesapellidos());
            statement.setString(5,Vdto.getDesapellidos());
            statement.executeUpdate();
        } catch(Exception ex) {
            throw new DaoException(ex);
        }finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }
    }

    public void delete(Vendedor Vdto) throws DaoException {
        String DELETE = "DELETE FROM vendedor where nmvendedor =?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, Vdto.getNmvendedor());
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

    public void update(Vendedor Vdto) throws DaoException {
        String UPDATE = "UPDATE vendedor SET documento=?,dsnombres=?,desapellidos=?,dsdireccion=? where nmvendedor=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();

        try {

            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, Vdto.getDocumento());
            statement.setString(2, Vdto.getDsnombres());
            statement.setString(3, Vdto.getDesapellidos());
            statement.setString(4, Vdto.getDsdireccion());
            statement.setInt(5, Vdto.getNmvendedor());
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

    public Vendedor selectbyid(Vendedor Vdto) throws DaoException {
        Vendedor result = null;
        String SELECT = " SELECT nmvendedor,documento,dsnombres,desapellidos,dsdireccion from vendedor where nmvendedor=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, Vdto.getNmvendedor());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = new Vendedor();
                result.setNmvendedor(resultSet.getInt("nmvendedor"));
                result.setDocumento(resultSet.getString("documento"));
                result.setDocumento(resultSet.getString("dsnombres"));
                result.setDocumento(resultSet.getString("desapellidos"));
                result.setDocumento(resultSet.getString("dsdireccion"));
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

    public List<Vendedor> selectall() throws DaoException {
        List<Vendedor> list = new ArrayList<>();
        String SELECT = " SELECT nmvendedor,documento,dsnombres,desapellidos,dsdireccion FROM vendedor";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vendedor v = new Vendedor();
                v.setNmvendedor(resultSet.getInt("nmvendedor"));
                v.setDocumento(resultSet.getString("documento"));
                v.setDsnombres(resultSet.getString("dsnombres"));
                v.setDesapellidos(resultSet.getString("desapellidos"));
                v.setDsdireccion(resultSet.getString("dsdireccion"));
                list.add(v);
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
