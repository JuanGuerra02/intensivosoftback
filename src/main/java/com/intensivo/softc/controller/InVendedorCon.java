package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.ConException;

import java.util.List;

public interface InVendedorCon {

    public void update(Vendedor v) throws ConException;

    public void delete(Vendedor v)throws ConException;

    public List<Vendedor> selectall( )throws ConException;
}
