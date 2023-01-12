package com.intensivo.softc.dao;

import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.dto.Producto;
import com.intensivo.softc.exception.DaoException;

import java.util.List;

public interface InFacturaDao {

    public void insert(Factura facturadto )throws DaoException;
    public void update(Factura facturadto )throws DaoException;
    public void delete(Factura facturadto )throws DaoException;
    public Factura selectbyid(Factura facturadto )throws DaoException;
    public List<Factura> selectall( )throws DaoException;

}
