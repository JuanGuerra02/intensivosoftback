package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.InFacturaDao;
import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacturaMgr implements InFacturaMgr {

    @Autowired
    private InFacturaDao facturaDao  ;


    public void  insert(Factura f) throws MgrException {

        try {
            Factura id= facturaDao.selectbyid(f);
            if (id == null){
                facturaDao.insert(f);
            }else {
                facturaDao.update(f);
            }
        }catch (Exception e){
            throw new MgrException(e);
        }
    }

    public void delete(Factura f) throws MgrException {
        try {
            Factura id = facturaDao.selectbyid(f);
            if (id != null) {
                facturaDao.delete(f);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public List<Factura> selectall() throws MgrException {
        try {
            return facturaDao.selectall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }


}
