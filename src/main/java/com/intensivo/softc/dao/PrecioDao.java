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


@Component
public class PrecioDao implements InPrecioDao {

    public void insert(Precio prdto) throws DaoException {
        String INSERT = "insert into precio(nmprecio,sku,precio, fedesde,fehasta) values (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, prdto.getNmprecio());
            statement.setString(2,prdto.getSku().getSku());
            statement.setDouble(3, prdto.getPrecio());
            statement.setDate(4, (Date) prdto.getFedesde());
            statement.setDate(5, (Date) prdto.getFehasta());
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

    public Precio selectbyid(Precio preciodto) throws DaoException {
        Precio result =null;
        String SELECT="select PE.nmprecio,PO.sku,PE.precio,PE.fedesde,PE.fehasta \n" +
                "from precio PE\n" +
                "inner join productos PO on PO.sku=PE.sku\n" +
                "where PE.nmprecio = ?";
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
                producto.setDsproducto(resultSet.getString("dsproducto"));
                result.setSku(producto);

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
}


