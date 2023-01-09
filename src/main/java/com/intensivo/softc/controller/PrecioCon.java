package com.intensivo.softc.controller;

import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.PrecioFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrecioCon {

    @Autowired
    private PrecioFac prfac;

    @PostMapping("/precio/insert")
    public ResponseEntity<Mensaje> insert(@RequestBody Precio p) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            prfac.insert(p);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El precio fue guardado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al guardar el precio");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
}
