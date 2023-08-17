package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.TextJsonService;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();
        List<String> lista = new ArrayList<>();
        lista.add("/paginas/compras/procesos/facturaProveedor.xhtml");
        lista.add("/paginas/compras/procesos/recepcionProveedor.xhtml");
        lista.add("/paginas/compras/Reportes/reporteA.xhtml");
        lista.add("/paginas/compras/Reportes/reporteB.xhtml");
        lista.add("/paginas/nomina/configuracion/empleados/empleado.xhtml");
        TextJsonService textJsonService = new TextJsonService(new ObjectMapper());
        System.out.println(textJsonService.createJson(lista));
    }


}
