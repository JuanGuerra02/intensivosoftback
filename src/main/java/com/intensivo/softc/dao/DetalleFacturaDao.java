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
public class DetalleFacturaDao implements  InDetalleFacturaDao{

    public void insert(DetalleFactura Dfacturadto) throws DaoException {
        String INSERT = "INSERT INTO detallefactura (nmdetfactura, sku, nmfactura, cantidad, nmprecio, precio) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, Dfacturadto.getNmdetfactura());
            statement.setString(2, Dfacturadto.getDSku().getSku());
            statement.setInt(3, Dfacturadto.getDnmfactura().getNmfactura());
            statement.setInt(4, Dfacturadto.getCantidad());
            statement.setInt(5, Dfacturadto.getDnmprecio().getNmprecio());
            statement.setDouble(6,Dfacturadto.getDprecio());
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


    public void update(DetalleFactura Dfacturadto) throws DaoException {
        String UPDATE = "UPDATE detallefactura SET  sku=?, nmfactura=?, cantidad=?, nmprecio=?, precio=? where nmdetfactura=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, Dfacturadto.getDSku().getSku());
            statement.setInt(2, Dfacturadto.getDnmfactura().getNmfactura());
            statement.setInt(3, Dfacturadto.getCantidad());
            statement.setInt(4, Dfacturadto.getDnmprecio().getNmprecio());
            statement.setDouble(5,Dfacturadto.getDprecio());
            statement.setInt(6, Dfacturadto.getNmdetfactura());
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


    public void delete(DetalleFactura facturadto) throws DaoException {
        String DELETE = "DELETE FROM  detallefactura where nmdetfactura =?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, facturadto.getNmdetfactura());
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

    public DetalleFactura selectbyid(DetalleFactura Dfacturadto) throws DaoException {
        DetalleFactura result =null;
        String SELECT="SELECT * FROM detallefactura WHERE nmdetfactura = ?";
        PreparedStatement statement=null;
        ResultSet resultSet= null;
        Connection connection =Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, Dfacturadto.getNmdetfactura());
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                result = new DetalleFactura();
                result.setNmdetfactura(resultSet.getInt("nmdetfactura"));

                Producto producto= new Producto();
                producto.setSku(resultSet.getString("sku"));
                result.setDSku(producto);

                Factura factura= new Factura();
                factura.setNmfactura(resultSet.getInt("nmfactura"));
                result.setDnmfactura(factura);

                result.setCantidad(resultSet.getInt("cantidad"));

                Precio precio= new Precio();
                precio.setNmprecio(resultSet.getInt("nmprecio"));
                result.setDnmprecio(precio);

                result.setDprecio(resultSet.getDouble("precio"));

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

    public List<DetalleFactura> selectall() throws DaoException {
        List<DetalleFactura> list = new ArrayList<>();
        String SELECT = " SELECT * FROM detallefactura";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DetalleFactura dfactura = new DetalleFactura();
                dfactura.setNmdetfactura(resultSet.getInt("nmdetfactura"));

                Producto producto= new Producto();
                producto.setSku(resultSet.getString("sku"));
                dfactura.setDSku(producto);

                Factura factura= new Factura();
                factura.setNmfactura(resultSet.getInt("nmfactura"));
                dfactura.setDnmfactura(factura);

                dfactura.setCantidad(resultSet.getInt("cantidad"));

                Precio precio= new Precio();
                precio.setNmprecio(resultSet.getInt("nmprecio"));
                dfactura.setDnmprecio(precio);

                dfactura.setDprecio(resultSet.getDouble("precio"));

                list.add(dfactura);
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
