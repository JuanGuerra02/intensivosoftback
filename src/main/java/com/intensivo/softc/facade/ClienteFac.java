package com.intensivo.softc.facade;

import com.intensivo.softc.database.Managerconexion;
import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.mgr.ClienteMgr;
import com.intensivo.softc.mgr.InClienteMgr;


import java.util.List;

public class ClienteFac implements  InClienteFac{
    private InClienteMgr cmgr;

    public ClienteFac() {

        this.cmgr = new ClienteMgr();
    }

    public void save (Cliente c)throws FacException {
        try {
            Managerconexion.getInstance().open();
            cmgr.save(c);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }

    public void delete(Cliente c)throws FacException{
        try {
            Managerconexion.getInstance().open();
            cmgr.delete(c);
            Managerconexion.getInstance().commit();
        }catch (Exception ex){
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }

    public void update(Cliente c)throws FacException {
        try {
            Managerconexion.getInstance().open();
            cmgr.update(c);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<Cliente> selectall( ) throws FacException {
        Managerconexion.getInstance().open();
        try {
            return cmgr.selectall();
        }catch (Exception ex){

            throw new FacException(ex);
        }finally {
            Managerconexion.getInstance().close();
        }
    }
}

