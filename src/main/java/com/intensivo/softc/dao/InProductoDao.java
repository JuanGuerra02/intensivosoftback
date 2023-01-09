package com.intensivo.softc.dao;



import com.intensivo.softc.exception.DaoException;
import com.intensivo.softc.dto.Producto;

import java.util.List;

public interface InProductoDao {
    public void insert(Producto Pdto )throws DaoException;
    public void update(Producto Pdto )throws DaoException;
    public void delete(Producto Pdto )throws DaoException;
    public Producto selectbyid(Producto Pdto )throws DaoException;
    public List<Producto>selectall( )throws DaoException;

}
