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
                new Mueble("1", "Sofá LANDSKRONA", 499, "clasico", "sofá", "https://www.ikea.com/es/es/images/products/landskrona-sofa-2-plazas-gunnared-verde-claro-madera__0602106_pe680175_s5.jpg?f=xl")
                new Mueble("1", "Sofá VINLIDEN", 499, "clasico", "sofá", "https://www.ikea.com/es/es/images/products/vinliden-sofa-2-plazas-hakebo-beige__0852697_pe780205_s5.jpg?f=xl")
                new Mueble("1", "Sofá ESKILSTUNA", 799, "moderno", "sofá", "https://www.ikea.com/es/es/images/products/eskilstuna-sofa-3-plazas-con-chaiselongue-hillared-antracita__1256233_pe924958_s5.jpg?f=xl")
                new Mueble("1", "Sofá BÅRSLÖV", 499, "moderno", "sofá", "https://www.ikea.com/es/es/images/products/barslov-sofa-cama-3-plazas-con-chaiselongue-tibbleby-beis-gris__1213693_pe911220_s5.jpg?f=xl")
                new Mueble("1", "Sofá REVSKÄR", 596, "industrial", "sofá", "https://www.ikea.com/es/es/images/products/revskar-conjunto-3-plazas-exterior-antracita-froson-duvholmen-gris-oscuro__1240165_pe919197_s5.jpg?f=xl")
                new Mueble("1", "Sofá KLIPPAN", 279, "industrial", "sofá", "https://www.ikea.com/es/es/images/products/klippan-sofa-2-plazas-vissle-gris__0239990_pe379591_s5.jpg?f=xl")
        ));

        mueblesPorCategoria.put("mesas", Arrays.asList(
                new Mueble("2", "Mesa LACK", 49.99, "moderno", "mesa", "https://example.com/images/mesa_lack.jpg")
        ));

        return mueblesPorCategoria;
    }
}
