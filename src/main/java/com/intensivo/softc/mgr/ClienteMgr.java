package com.intensivo.softc.mgr;

import com.intensivo.softc.dao.ClienteDao;
import com.intensivo.softc.dao.InClienteDao;
import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.MgrException;

import java.util.List;

public class ClienteMgr implements InClienteMgr{

    private InClienteDao Cdao;

    public ClienteMgr() {
        this.Cdao = new ClienteDao();
    }

    public void save(Cliente c) throws MgrException {
        try {
            Cliente sp = Cdao.selectbyid(c);
            if (sp == null) {
                Cdao.insert(c);
            } else {
                Cdao.equals(c);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public void delete(Cliente c) throws MgrException {
        try {
            Cliente dp = Cdao.selectbyid(c);
            if (dp != null) {
                Cdao.delete(c);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public void update(Cliente c) throws MgrException {
        try {
            Cliente sp = Cdao.selectbyid(c);
            if (sp != null) {
                Cdao.update(c);
            } else {
                Cdao.insert(c);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public List<Cliente> selectall() throws MgrException {
        try {
            return Cdao.selectall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }

    }
}
