package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.PrecioFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrecioCon {

    @Autowired
    private PrecioFac preciofac;

    @PostMapping("/precio/insert")
    public ResponseEntity<Mensaje> insert(@RequestBody Precio p) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            preciofac.insert(p);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El precio fue guardado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al guardar el precio");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/producto/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody Precio p) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            preciofac.delete(p);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue eliminado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/precio/selectall")
    public ResponseEntity<Mensaje> selectall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<Precio> list = preciofac.selectall();
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
