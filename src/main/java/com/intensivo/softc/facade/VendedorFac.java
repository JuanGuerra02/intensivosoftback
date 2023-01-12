package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.InVendedorMgr;
import com.intensivo.softc.mgr.VendedorMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class VendedorFac implements InVendedorFac{

    @Autowired
    private InVendedorMgr vmgr;
    /*
    public VendedorFac() {

        this.vmgr = new VendedorMgr();
    }
    */
    public void save (Vendedor v)throws FacException {
        try {
            Managerconexion.getInstance().open();
            vmgr.save(v);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }

    public void delete(Vendedor v)throws FacException{
        try {
            Managerconexion.getInstance().open();
            vmgr.delete(v);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }

    public void update(Vendedor v)throws FacException{
        try {
            Managerconexion.getInstance().open();
            vmgr.update(v);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<Vendedor> selectall( ) throws FacException {
        Managerconexion.getInstance().open();
        try {
            return vmgr.selectall();
        }catch (Exception ex){
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }
}
