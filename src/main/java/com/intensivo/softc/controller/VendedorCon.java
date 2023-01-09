package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.InVendedorFac;


import java.util.List;

public class VendedorCon implements InVendedorCon{

    private InVendedorFac vfac;

    public void save(Vendedor v) throws ConException {
        try {
            vfac.save(v);
        }catch (Exception ex){
            throw new ConException(ex);
        }
    }

    public void update(Vendedor v) throws  ConException{
        try {
            vfac.update(v);
        }catch (Exception ex){
            throw new ConException(ex);
        }
    }

    public void delete(Vendedor v)throws ConException{
        try {
            vfac.delete(v);
        }catch (Exception ex){
            throw new ConException(ex);
        }
    }

    public List<Vendedor> selectall( )throws ConException{
        try {
            return vfac.selectall();
        }catch (Exception ex){
            throw new ConException(ex);
        }
    }
}
