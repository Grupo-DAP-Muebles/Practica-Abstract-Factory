package com.example.muebles_api;

import com.example.muebles_api.Mueble;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/muebles")
public class MuebleController {

    @GetMapping
    public Map<String, List<Mueble>> obtenerMuebles() {
        Map<String, List<Mueble>> mueblesPorCategoria = new HashMap<>();

        mueblesPorCategoria.put("sillas", Arrays.asList(
                new Mueble("3", "Silla STEFAN", 35.00, "moderno", "silla", "https://www.ikea.com/es/es/images/products/stefan-silla-blanco__1322933_pe942332_s5.jpg?f=xl"),
                new Mueble("4", "Silla JANINGE", 59.00, "moderno", "silla", "https://example.com/images/silla_janinge.jpg"),
                new Mueble("5", "Silla ODFER", 79.00, "moderno", "silla", "https://example.com/images/silla_odfer.jpg")
        ));

        mueblesPorCategoria.put("sofás", Arrays.asList(
                new Mueble("1", "Sofá EKTORP", 299.99, "moderno", "sofá", "https://example.com/images/sofa_ektorp.jpg")
        ));

        mueblesPorCategoria.put("mesas", Arrays.asList(
                new Mueble("2", "Mesa LACK", 49.99, "moderno", "mesa", "https://example.com/images/mesa_lack.jpg")
        ));

        return mueblesPorCategoria;
    }
}
