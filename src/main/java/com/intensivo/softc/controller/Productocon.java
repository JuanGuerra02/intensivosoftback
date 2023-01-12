package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.InProductoFac;
import com.intensivo.softc.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Productocon {

    @Autowired
    private InProductoFac pfac;

    /*public Productocon() {
        this.pfac = new Productofac() ;
    }*/


    @PostMapping("/producto/save")
    public ResponseEntity<Mensaje> save(@RequestBody Producto p) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            pfac.save(p);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue insertado ");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al insertar ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/producto/update")
    public ResponseEntity<Mensaje> update(@RequestBody Producto p) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            pfac.update(p);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue actualizado ");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al actualizar ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/producto/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody Producto p) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            pfac.delete(p);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue eliminado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/producto/selectall")
    public ResponseEntity<Mensaje> selectall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<Producto> list = pfac.selectall();
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
