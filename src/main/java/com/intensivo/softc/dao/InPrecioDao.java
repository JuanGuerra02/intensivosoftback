package com.intensivo.softc.dao;

import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.dto.Producto;
import com.intensivo.softc.exception.DaoException;

import java.util.List;

public interface InPrecioDao {

    public void insert(Precio preciodto) throws DaoException;

    public void update(Precio preciodto) throws DaoException;
    public void delete(Precio preciodto) throws DaoException;

    public Precio selectbyid(Precio preciodto) throws DaoException;

    public List<Precio> selectall( )throws DaoException;


}
