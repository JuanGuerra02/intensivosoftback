package com.intensivo.softc.dao;



import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.DaoException;

import java.util.List;

public interface InClienteDao {

    public void insert(Cliente Cdto )throws DaoException;
    public void update(Cliente Cdto )throws DaoException;
    public void delete(Cliente Cdto )throws DaoException;
    public Cliente selectbyid(Cliente Cdto )throws DaoException;
    public List<Cliente> selectall( )throws DaoException;
}
