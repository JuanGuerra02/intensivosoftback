package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Cliente;
import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.ClienteFac;
import com.intensivo.softc.facade.InClienteFac;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api")

public class ClienteCon {

    private InClienteFac cfac;

    public ClienteCon() {
        this.cfac = new ClienteFac();
    }

    @PostMapping("/Cliente/save")
    public ResponseEntity<Mensaje> save(@RequestBody Cliente c)throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            cfac.save(c);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue insertado ");
        }catch (Exception ex){
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al insertar ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/Cliente/update")
    public ResponseEntity<Mensaje> update(@RequestBody Cliente c) throws  ConException{
        Mensaje mensaje = new Mensaje();
        try {
            cfac.update(c);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue actualizado ");
        }catch (Exception ex){
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al actualizar ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/Cliente/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody Cliente c)throws ConException{
        Mensaje mensaje =new Mensaje();
        try {
            cfac.delete(c);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue eliminado");
        }catch (Exception ex){
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/Cliente/selectall")
    public ResponseEntity<Mensaje> selectall( )throws ConException{
        Mensaje mensaje = new Mensaje();
        try {
            List<Cliente> list =cfac.selectall();
            mensaje.setCodigo(0);
            mensaje.setMensaje("Datos completos ");
            mensaje.setData(list);
        }catch (Exception ex){
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al mostrar datos ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
}
