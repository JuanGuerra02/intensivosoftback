package com.intensivo.softc.dao;

import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.DaoException;


import java.util.List;

public interface InVendedorDao {

    public void insert(Vendedor Vdto )throws DaoException;
    public void update(Vendedor Vdto )throws DaoException;
    public void delete(Vendedor Vdto )throws DaoException;
    public Vendedor selectbyid(Vendedor Vdto )throws DaoException;
    public List<Vendedor> selectall( )throws DaoException;


}
