package com.intensivo.softc.mgr;

import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.exception.MgrException;


import java.util.List;

public interface InClienteMgr {

    public void save(Cliente c) throws MgrException;

    public void delete( Cliente c)throws MgrException;

    public void update(Cliente c) throws MgrException;

    public List<Cliente> selectall( )throws MgrException;
}
