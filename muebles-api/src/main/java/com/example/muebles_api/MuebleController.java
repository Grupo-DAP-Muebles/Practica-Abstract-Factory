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
        // Organizar los muebles en grupos
        Map<String, List<Mueble>> mueblesPorCategoria = new HashMap<>();

        mueblesPorCategoria.put("sillas", Arrays.asList(
                new Mueble("3", "Silla STEFAN", 35.00, "silla"),
                new Mueble("4", "Silla JANINGE", 59.00, "silla"),
                new Mueble("5", "Silla ODFER", 79.00, "silla")
        ));

        mueblesPorCategoria.put("sofás", Arrays.asList(
                new Mueble("1", "Sofá EKTORP", 299.99, "sofá")
        ));

        mueblesPorCategoria.put("mesas", Arrays.asList(
                new Mueble("2", "Mesa LACK", 49.99, "mesa")
        ));

        return mueblesPorCategoria;
    }
}