package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.InProductoMgr;
import com.intensivo.softc.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class Productofac implements InProductoFac {

    @Autowired
    private InProductoMgr pmgr;


    public void save(Producto p) throws FacException {
        try {
            Managerconexion.getInstance().open();
            pmgr.save(p);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public void delete(Producto p) throws FacException {
        try {
            Managerconexion.getInstance().open();
            pmgr.delete(p);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public void update(Producto p) throws FacException {
        try {
            Managerconexion.getInstance().open();
            pmgr.update(p);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<Producto> selectall() throws FacException {
        Managerconexion.getInstance().open();
        try {

            return pmgr.selectall();

        } catch (Exception ex) {

            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

}
