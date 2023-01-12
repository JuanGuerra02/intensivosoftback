package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.FacturaFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacturaCon {

    @Autowired
    private FacturaFac facturafac;

    @PostMapping("/factura/insert")
    public ResponseEntity<Mensaje> insert(@RequestBody Factura f) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            facturafac.insert(f);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El precio fue guardado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al guardar el precio");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/factura/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody Factura f) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            facturafac.delete(f);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El objeto fue eliminado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/factura/selectall")
    public ResponseEntity<Mensaje> selectall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<Factura> list = facturafac.selectall();
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
