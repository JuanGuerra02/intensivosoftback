package com.intensivo.softc.controller;

import com.intensivo.softc.dto.DetalleFactura;
import com.intensivo.softc.dto.Mensaje;
import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.facade.DetalleFacturaFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetalleFacturaCon {

    @Autowired
    private DetalleFacturaFac Dfacturafac;

    @PostMapping("/Dfactura/insert")
    public ResponseEntity<Mensaje> insert(@RequestBody DetalleFactura d) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            Dfacturafac.insert(d);
            mensaje.setCodigo(0);
            mensaje.setMensaje("Se Guardo el detalle de la factura");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al guardar el Detalle de la factura");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("/Dfactura/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody DetalleFactura d) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            Dfacturafac.delete(d);
            mensaje.setCodigo(0);
            mensaje.setMensaje("Se elimino el detalle de la factura");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/Dfactura/selectall")
    public ResponseEntity<Mensaje> selectall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<DetalleFactura> list = Dfacturafac.selectall();
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
