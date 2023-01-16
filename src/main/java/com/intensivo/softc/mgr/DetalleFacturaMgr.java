package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.InDetalleFacturaDao;
import com.intensivo.softc.dto.DetalleFactura;
import com.intensivo.softc.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetalleFacturaMgr implements InDetalleFacturaMgr{


    @Autowired
    private InDetalleFacturaDao Dfacturadao;

    public void insert(DetalleFactura d ) throws MgrException {

        try {
            DetalleFactura id = Dfacturadao.selectbyid(d);
            if (id == null){
                Dfacturadao.insert(d);
            }else {
                Dfacturadao.update(d);
            }
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete(DetalleFactura d) throws MgrException{
        try {
            DetalleFactura id = Dfacturadao.selectbyid(d);
            if (id != null) {
                Dfacturadao.delete(d);
            }
        } catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<DetalleFactura> selectall() throws MgrException {
        try {
            return Dfacturadao.selectall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

}
