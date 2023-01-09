package com.intensivo.softc.facade;

import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.FacException;


import java.util.List;

public interface InVendedorFac {

    public void save (Vendedor v)throws FacException;

    public void delete(Vendedor v)throws FacException;

    public void update(Vendedor v)throws FacException;

    public List<Vendedor> selectall( )throws FacException;

}
