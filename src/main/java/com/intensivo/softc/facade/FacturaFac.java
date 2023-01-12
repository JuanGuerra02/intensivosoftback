package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.InFacturaMgr;
import com.intensivo.softc.mgr.InPrecioMgr;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FacturaFac implements InFacturaFac{

    @Autowired
    private InFacturaMgr facturaMgr;

    public void insert(Factura f) throws FacException {
        try {
            Managerconexion.getInstance().open();
            facturaMgr.insert(f);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }
    public void delete(Factura f) throws FacException {
        try {
            Managerconexion.getInstance().open();
            facturaMgr.delete(f);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<Factura> selectall() throws FacException {
        Managerconexion.getInstance().open();
        try {
            return facturaMgr.selectall();
        } catch (Exception ex) {
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
}
