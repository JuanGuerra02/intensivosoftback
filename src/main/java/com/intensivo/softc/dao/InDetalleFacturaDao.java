package com.intensivo.softc.dao;

import com.intensivo.softc.dto.DetalleFactura;
import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.exception.DaoException;

import java.util.List;

public interface InDetalleFacturaDao {

    public void insert(DetalleFactura Dfacturadto) throws DaoException;

    public void update(DetalleFactura Dfacturadto) throws DaoException;

    public void delete(DetalleFactura facturadto) throws DaoException;

    public DetalleFactura selectbyid(DetalleFactura Dfacturadto) throws DaoException;

    public List<DetalleFactura> selectall() throws DaoException;



}
