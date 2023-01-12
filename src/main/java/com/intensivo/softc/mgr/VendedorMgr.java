package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.InVendedorDao;
import com.intensivo.softc.dao.VendedorDao;
import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class VendedorMgr implements InVendedorMgr {
    @Autowired
    private InVendedorDao vdao;
/*
    public VendedorMgr(){this.vdao = new VendedorDao();}
*/
    public void save(Vendedor v) throws MgrException {
        try {
            Vendedor sp = vdao.selectbyid(v);
            if (sp == null) {
                vdao.insert(v);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete( Vendedor v)throws MgrException {
        try {
            Vendedor dv = vdao.selectbyid(v);
            if (dv!=null){
                vdao.delete(v);
            }
        }
        catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void update(Vendedor v) throws MgrException{
        try {
            Vendedor sp = vdao.selectbyid(v);
            if (sp != null) {
                vdao.update(v);
            } else {
                vdao.insert(v);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Vendedor> selectall( )throws MgrException{
        try {
            return vdao.selectall();
        }catch (Exception ex){
            throw new MgrException(ex);
        }

    }

}
