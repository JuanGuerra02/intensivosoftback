package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.DetalleFactura;
import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.InDetalleFacturaMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetalleFacturaFac implements InDetalleFacturaFac{

    @Autowired
    private InDetalleFacturaMgr Dfacturamgr;

    public void insert(DetalleFactura d) throws FacException{

        try {
            Managerconexion.getInstance().open();
            Dfacturamgr.insert(d);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().close();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }

    public void delete(DetalleFactura d) throws FacException {
        try {
            Managerconexion.getInstance().open();
            Dfacturamgr.delete(d);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<DetalleFactura> selectall() throws FacException {
        Managerconexion.getInstance().open();
        try {
            return Dfacturamgr.selectall();
        } catch (Exception ex) {
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
}
