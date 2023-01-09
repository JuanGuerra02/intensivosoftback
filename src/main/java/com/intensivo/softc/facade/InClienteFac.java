package com.intensivo.softc.facade;

import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.FacException;


import java.util.List;

public interface InClienteFac {

    public void save (Cliente c)throws FacException;

    public void delete(Cliente c)throws FacException;

    public void update(Cliente c)throws FacException;

    public List<Cliente> selectall( )throws FacException;

}
