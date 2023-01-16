package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.InPrecioMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrecioFac implements InPrecioFa{

    @Autowired
    private InPrecioMgr precioMgr;

    public void insert(Precio p) throws FacException{
        try {
            Managerconexion.getInstance().open();
            precioMgr.insert(p);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }
    public void delete(Precio p) throws FacException {
        try {
            Managerconexion.getInstance().open();
            precioMgr.delete(p);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<Precio> selectall() throws FacException {
        Managerconexion.getInstance().open();
        try {
            return precioMgr.selectall();
        } catch (Exception ex) {
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
}
