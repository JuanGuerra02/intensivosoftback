package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.ConException;


import java.util.List;

public interface InClienteCon {

    public void update(Cliente c) throws ConException;

    public void delete(Cliente c)throws ConException;

    public List<Cliente> selectall( )throws ConException;
}
