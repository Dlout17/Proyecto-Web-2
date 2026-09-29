package com.example.demo.controlador;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Alquiler;
import com.example.demo.repositorio.AlquilerRepositorio;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin(origins = "http://localhost:4200")
public class AlquilerControlador {

private final AlquilerRepositorio alquilerRepositorio;

public AlquilerControlador(AlquilerRepositorio alquilerRepositorio) {
    this.alquilerRepositorio = alquilerRepositorio;
}

@GetMapping("/listar")
public List<Alquiler> listar() {
    return alquilerRepositorio.findAll();
}

@GetMapping("/buscarAlquiler")
public Optional<Alquiler> buscar(
        @RequestParam String numeroAlquiler) {

    return alquilerRepositorio.findById(numeroAlquiler);
}

@GetMapping("/buscarUsuario")
public List<Alquiler> alquileresUsuario(
        @RequestParam String idUsuario) {

    return alquilerRepositorio.findByIdUsuario(idUsuario);
}

@GetMapping("/buscarEstado")
public List<Alquiler> alquileresEstado(
        @RequestParam String estado) {

    return alquilerRepositorio.findByEstado(estado);
}

@GetMapping("/buscarPlaca")
public List<Alquiler> alquileresPlaca(
        @RequestParam String placa) {

    return alquilerRepositorio.findByPlaca(placa);
}

@GetMapping("/buscarFecha-inicio")
public List<Alquiler> alquileresFecha(
        @RequestParam LocalDate fechaInicio) {

    return alquilerRepositorio.findByFechaInicio(fechaInicio);
}

@GetMapping("/buscarFecha-entrega")
public List<Alquiler> alquileresFechaEntrega(
        @RequestParam LocalDate fechaEntrega) {

    return alquilerRepositorio.findByFechaEntrega(fechaEntrega);
}

@GetMapping("/buscarPlaca-estado")
public List<Alquiler> placaEstado(
        @RequestParam String placa,
        @RequestParam String estado) {

    return alquilerRepositorio.findByPlacaAndEstado(placa, estado);
}

@GetMapping("/buscarRrango")
public List<Alquiler> alquileresRango(
        @RequestParam LocalDate fechaInicio,
        @RequestParam LocalDate fechaFin) {

    return alquilerRepositorio.findByFechaInicioBetween(
            fechaInicio,
            fechaFin
    );
}

@GetMapping("/cantidad-estado")
public long cantidadPorEstado(
        @RequestParam String estado) {

    return alquilerRepositorio.countByEstado(estado);
}

@GetMapping("/buscarUsuario-estado")
public List<Alquiler> usuarioEstado(
        @RequestParam String idUsuario,
        @RequestParam String estado) {

    return alquilerRepositorio.findByIdUsuarioAndEstado(
            idUsuario,
            estado
    );
}

// CREAR SOLICITUD DE ALQUILER
@PostMapping("/guardar")
public Alquiler guardar(@RequestBody Alquiler alquiler) {

    String numero = "ALQ-" + System.currentTimeMillis();

    alquiler.setNumeroAlquiler(numero);

    alquiler.setEstado("pendiente de entrega");

    if (alquiler.getFechaInicio() == null ||
            alquiler.getFechaEntrega() == null) {

        throw new RuntimeException(
                "Debe ingresar las fechas del alquiler"
        );
    }

    if (!alquiler.getFechaEntrega()
            .isAfter(alquiler.getFechaInicio())) {

        throw new RuntimeException(
                "La fecha de entrega debe ser posterior a la fecha de inicio"
        );
    }

    return alquilerRepositorio.save(alquiler);
}

@PutMapping("/actualizar")
public Alquiler actualizar(@RequestBody Alquiler alquiler) {

    return alquilerRepositorio.save(alquiler);
}

// CANCELAR ALQUILER
@PutMapping("/cancelar")
public String cancelar(
        @RequestParam String numeroAlquiler) {

    Optional<Alquiler> alquiler =
            alquilerRepositorio.findById(numeroAlquiler);

    if (alquiler.isPresent()) {

        alquiler.get().setEstado("Cancelado");

        alquilerRepositorio.save(alquiler.get());

        return "Alquiler cancelado correctamente";
    }

    return "Alquiler no encontrado";
}

// ELIMINAR
@DeleteMapping("/eliminar")
public String eliminar(
        @RequestParam String numeroAlquiler) {

    Optional<Alquiler> alquiler =
            alquilerRepositorio.findById(numeroAlquiler);

    if (alquiler.isPresent()) {

        alquilerRepositorio.deleteById(numeroAlquiler);

        return "Alquiler eliminado correctamente";
    }

    return "Alquiler no encontrado";
}

// GENERAR PDF
@GetMapping("/pdf")
public ResponseEntity<byte[]> generarPDF(@RequestParam String numeroAlquiler) {

    Optional<Alquiler> alquiler = alquilerRepositorio.findById(numeroAlquiler);

    if (alquiler.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    try {

        ByteArrayOutputStream salida = new ByteArrayOutputStream();

        Document documento = new Document();
        PdfWriter.getInstance(documento, salida);

        documento.open();

        documento.add(new Paragraph("MI CACHARRITO"));
        documento.add(new Paragraph("COMPROBANTE DE ALQUILER"));
        documento.add(new Paragraph("--------------------------------"));

        documento.add(new Paragraph(
            "Numero de alquiler: " + alquiler.get().getNumeroAlquiler()
        ));

        documento.add(new Paragraph(
            "Usuario: " + alquiler.get().getNombreUsuario()
        ));

        documento.add(new Paragraph(
            "Identificacion: " + alquiler.get().getIdUsuario()
        ));

        documento.add(new Paragraph(
            "Tipo de vehiculo: " + alquiler.get().getTipoVehiculo()
        ));

        documento.add(new Paragraph(
            "Placa: " + alquiler.get().getPlaca()
        ));

        documento.add(new Paragraph(
            "Color: " + alquiler.get().getColor()
        ));

        documento.add(new Paragraph(
            "Fecha inicio: " + alquiler.get().getFechaInicio()
        ));

        documento.add(new Paragraph(
            "Fecha entrega: " + alquiler.get().getFechaEntrega()
        ));

        documento.add(new Paragraph(
            "Valor total: $" + alquiler.get().getValorTotal()
        ));

        documento.add(new Paragraph(
            "Estado: " + alquiler.get().getEstado()
        ));

        documento.close();

        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=alquiler-" +
                        numeroAlquiler + ".pdf")
                .header("Content-Type", "application/pdf")
                .body(salida.toByteArray());

    } catch (Exception e) {
        return ResponseEntity.internalServerError().build();
    }
}}