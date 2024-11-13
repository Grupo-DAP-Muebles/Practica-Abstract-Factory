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
                new Mueble("903.392.33", "Silla STEFAN", 35.00, "moderno", "silla", "https://www.ikea.com/es/es/images/products/stefan-silla-blanco__1322933_pe942332_s5.jpg?f=xl"),
                new Mueble("002.460.78", "Silla JANINGE", 59.00, "moderno", "silla", "https://www.ikea.com/es/es/images/products/janinge-silla-blanco__0728156_pe736116_s5.jpg?f=xl"),
                new Mueble("603.599.96", "Silla ODGER", 79.00, "moderno", "silla", "https://www.ikea.com/es/es/images/products/odger-silla-blanco-beige__0727334_pe735606_s5.jpg?f=xl"),
                new Mueble("005.657.63", "Silla SKANSNAS", 89.00, "clasico", "silla", "https://www.ikea.com/es/es/images/products/skansnas-silla-marron-haya__1319860_pe941001_s5.jpg"),
                new Mueble("402.808.43", "Silla NORRARYD", 89.00, "clasico", "silla", "https://www.ikea.com/es/es/images/products/norraryd-silla-negro__0727327_pe735599_s5.jpg"),
                new Mueble("905.224.01", "Silla KULLABERG", 99.00, "industrial", "silla", "https://www.ikea.com/es/es/images/products/kullaberg-silla-confidente-pino-negro__0724693_pe734575_s5.jpg?f=xl")
            
        ));

        mueblesPorCategoria.put("sofás", Arrays.asList(
                new Mueble("392.703.26", "Sofá LANDSKRONA", 499, "clasico", "sofá", "https://www.ikea.com/es/es/images/products/landskrona-sofa-2-plazas-gunnared-verde-claro-madera__0602106_pe680175_s5.jpg?f=xl"),
                new Mueble("493.046.51", "Sofá VINLIDEN", 499, "clasico", "sofá", "https://www.ikea.com/es/es/images/products/vinliden-sofa-2-plazas-hakebo-beige__0852697_pe780205_s5.jpg?f=xl"),
                new Mueble("595.201.93", "Sofá ESKILSTUNA", 799, "moderno", "sofá", "https://www.ikea.com/es/es/images/products/eskilstuna-sofa-3-plazas-con-chaiselongue-hillared-antracita__1256233_pe924958_s5.jpg?f=xl"),
                new Mueble("805.415.94", "Sofá BÅRSLÖV", 499, "moderno", "sofá", "https://www.ikea.com/es/es/images/products/barslov-sofa-cama-3-plazas-con-chaiselongue-tibbleby-beis-gris__1213693_pe911220_s5.jpg?f=xl"),
                new Mueble("195.446.24", "Sofá REVSKÄR", 596, "industrial", "sofá", "https://www.ikea.com/es/es/images/products/revskar-conjunto-3-plazas-exterior-antracita-froson-duvholmen-gris-oscuro__1240165_pe919197_s5.jpg?f=xl"),
                new Mueble("790.106.14", "Sofá KLIPPAN", 279, "industrial", "sofá", "https://www.ikea.com/es/es/images/products/klippan-sofa-2-plazas-vissle-gris__0239990_pe379591_s5.jpg?f=xl")
        ));

        mueblesPorCategoria.put("mesas", Arrays.asList(
                new Mueble("804.499.01", "Mesa LACK", 49.99, "moderno", "mesa", "https://www.ikea.com/es/es/images/products/lack-mesa-centro-blanco__0750651_pe746801_s5.jpg?f=xl"),
                new Mueble("193.249.95", "Mesa Docksta", 179.00, "moderno", "mesa", "https://www.ikea.com/es/es/images/products/docksta-mesa-blanco-blanco__0803262_pe768820_s5.jpg?f=xl"),
                new Mueble("705.813.59", "Mesa Tarsele", 499.00, "industrial", "mesa", "https://www.ikea.com/es/es/images/products/tarsele-mesa-extensible-chapa-roble-negro__0916857_pe785431_s5.jpg?f=xl"),
                new Mueble("694.826.90", "Mesa Skogsta", 499.00, "industrial", "mesa", "https://www.ikea.com/es/es/images/products/skogsta-mesa-comedor-acacia-negro__0546603_pe656255_s5.jpg?f=xl"),
                new Mueble("402.170.69", "Mesa Ingatorp", 349.00, "clasico", "mesa", "https://www.ikea.com/es/es/images/products/ingatorp-mesa-extensible-blanco__0737089_pe740879_s5.jpg?f=xl"),
                new Mueble("105.159.42","Mesa Mariedamm", 249.00, "clasico", "mesa", "https://www.ikea.com/es/es/images/products/mariedamm-mesa-blanco-roble__1010541_pe828122_s5.jpg?f=xl")
        ));

        return mueblesPorCategoria;
    }
}
