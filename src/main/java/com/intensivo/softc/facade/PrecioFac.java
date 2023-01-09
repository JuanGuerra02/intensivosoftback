package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.InPrecioMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrecioFac implements InPrecioFa{

    @Autowired
    private InPrecioMgr prmgr;

    public void insert(Precio p) throws FacException{
        try {
            Managerconexion.getInstance().open();
            prmgr.insert(p);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }

    }
}
