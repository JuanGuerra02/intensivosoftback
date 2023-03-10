package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.InPrecioDao;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.dto.Producto;
import com.intensivo.softc.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrecioMgr implements InPrecioMgr {
    @Autowired
    private InPrecioDao preciodao;

    public void  insert(Precio p) throws MgrException{

        try {
            Precio ip= preciodao.selectbyid(p);
            if (ip == null){
                preciodao.insert(p);
            }else {
                preciodao.update(p);
            }
        }catch (Exception e){
            throw new MgrException(e);
        }
    }

    public void delete(Precio p) throws MgrException {
        try {
            Precio dp = preciodao.selectbyid(p);
            if (dp != null) {
                preciodao.delete(p);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public List<Precio> selectall() throws MgrException {
        try {
            return preciodao.selectall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }


}
