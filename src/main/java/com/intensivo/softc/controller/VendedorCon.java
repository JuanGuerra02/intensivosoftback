package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.InVendedorFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class VendedorCon {
    @Autowired
    private InVendedorFac vfac;
    @PostMapping("/vendedor/save")
    public ResponseEntity<Mensaje> save(@RequestBody Vendedor v) throws ConException {
       Mensaje mensaje = new Mensaje();
        try {
            vfac.save(v);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue insertado ");
        }catch (Exception ex){
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al insertar ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/vendedor/update")
    public ResponseEntity<Mensaje> update(@RequestBody Vendedor v) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            vfac.update(v);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue actualizado ");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al actualizar ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/vendedor/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody Vendedor v)throws ConException{
        Mensaje mensaje = new Mensaje();
        try {
            vfac.delete(v);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue eliminado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/vendedor/selectall")
    public ResponseEntity<Mensaje> selectall( )throws ConException{
        Mensaje mensaje = new Mensaje();
        try {
            List<Vendedor> list = vfac.selectall();
            mensaje.setCodigo(0);
            mensaje.setMensaje("Datos completos ");
            mensaje.setData(list);
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al mostrar datos ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
}
