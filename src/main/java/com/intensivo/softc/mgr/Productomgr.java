package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.InProductoDao;
import com.intensivo.softc.exception.MgrException;
import com.intensivo.softc.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Productomgr implements InProductoMgr {

    @Autowired
    private InProductoDao pdao;

  /*  public Productomgr() {
        this.pdao = new ProductoDao();
    }*/

    public void save(Producto p) throws MgrException {
        try {
            Producto sp = pdao.selectbyid(p);
            if (sp == null) {
                pdao.insert(p);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public void delete(Producto p) throws MgrException {
        try {
            Producto dp = pdao.selectbyid(p);
            if (dp != null) {
                pdao.delete(p);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public void update(Producto p) throws MgrException {
        try {
            Producto sp = pdao.selectbyid(p);
            if (sp != null) {
                pdao.update(p);
            } else {
                pdao.insert(p);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public List<Producto> selectall() throws MgrException {
        try {
            return pdao.selectall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }

    }

}
