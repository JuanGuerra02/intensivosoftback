package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.InPrecioDao;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrecioMgr implements InPrecioMgr {
    @Autowired
    private InPrecioDao prdao;

    public void  insert(Precio p) throws MgrException{

        try {
            Precio ip= prdao.selectbyid(p);
            if (ip == null){
                prdao.insert(p);
            }
        }catch (Exception e){
            throw new MgrException(e);
        }
    }
}
