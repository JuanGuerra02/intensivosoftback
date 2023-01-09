package com.intensivo.softc.dao;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements InClienteDao {


    public void insert(Cliente Cdto)throws DaoException {

        String INSERT ="INSERT INTO cliente (nmcliente,documento,dsnombres,desapellidos,dsdireccion) value (?,?,?,?,?);";
        PreparedStatement statement =null;
        Connection connection= Managerconexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setInt(1, Cdto.getNmcliente());
            statement.setString(2, Cdto.getDocumento());
            statement.setString(3, Cdto.getDsnombres());
            statement.setString(4, Cdto.getDesapellidos());
            statement.setString(5, Cdto.getDsdireccion());
            statement.executeUpdate();
        }catch (Exception ex){
            throw new DaoException(ex);
        }finally {
            try {
                statement.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void delete(Cliente Cdto)throws DaoException{
        String DELETE ="DELETE FROM cliente where nmcliente=?";
        PreparedStatement statement=null;
        Connection connection=Managerconexion.getInstance().getConnection();
        try {
            statement =connection.prepareStatement(DELETE);
            statement.setInt(1, Cdto.getNmcliente());
            statement.executeUpdate();
        }catch (Exception ex){
            throw new DaoException(ex);
        }finally {
            try{
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void update(Cliente Cdto )throws DaoException{
        String UPDATE = "UPDATE cliente SET documento=?,dsnombres=?,desapellidos=?,dsdireccion=? where nmcliente=?" ;
        PreparedStatement statement = null;
        Connection connection=Managerconexion.getInstance().getConnection();

        try {

            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, Cdto.getDocumento());
            statement.setString(2, Cdto.getDsnombres());
            statement.setString(3, Cdto.getDesapellidos());
            statement.setString(4, Cdto.getDsdireccion());
            statement.setInt(5, Cdto.getNmcliente());

            statement.executeUpdate();

        }catch (Exception ex){
            throw new DaoException(ex);
        }finally {
            try {
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public Cliente selectbyid(Cliente Cdto )throws DaoException{
        Cliente result =null;
        String SELECT =" SELECT nmcliente,documento,dsnombres,desapellidos,dsdireccion from cliente where nmcliente=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        Connection connection=Managerconexion.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, Cdto.getNmcliente());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = new Cliente();
                result.setNmcliente(resultSet.getInt("nmcliente"));
                result.setDocumento(resultSet.getString("documento"));
                result.setDsnombres(resultSet.getString("dsnombres"));
                result.setDesapellidos(resultSet.getString("desapellidos"));
                result.setDsdireccion(resultSet.getString("dsdireccion"));
            }
        }catch (Exception ex){
            throw new DaoException(ex);
        }finally {
            try{
                resultSet.close();
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public List<Cliente> selectall( )throws DaoException {
        List<Cliente> list = new ArrayList<>();
        String SELECT=" SELECT nmcliente,documento,dsnombres,desapellidos,dsdireccion FROM cliente";
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        Connection connection=Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Cliente c = new Cliente();
                c.setNmcliente(resultSet.getInt("nmcliente"));
                c.setDocumento(resultSet.getString("documento"));
                c.setDsnombres(resultSet.getString("dsnombres"));
                c.setDesapellidos(resultSet.getString("desapellidos"));
                c.setDsdireccion(resultSet.getString("dsdireccion"));
                list.add(c);
            }
        } catch (Exception ex) {
            throw new DaoException(ex);
        }finally {
            try{
                resultSet.close();
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
