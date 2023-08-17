package org.example.service;


import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

public class TextJsonServiceTest {

    private TextJsonService textJsonService;

    @BeforeEach
    void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        textJsonService = new TextJsonService(objectMapper);
    }


    @Test
    void testCreateDefaultJson() throws JsonProcessingException, JSONException {
        //given
        var list = Arrays.asList("/paginas/compras/procesos/facturaProveedor.xhtml",
                "/paginas/compras/procesos/recepcionProveedor.xhtml",
                "/paginas/compras/Reportes/reporteA.xhtml",
                "/paginas/compras/Reportes/reporteB.xhtml",
                "/paginas/nomina/configuracion/empleados/empleado.xhtml"
        );
        //when
        String result = textJsonService.createJson(list);
        System.out.println(result);
        //then
        String expected = """
                [
                  {
                    "label": "paginas",
                    "items": [
                      {
                        "label": "compras",
                        "items": [
                          {
                            "label": "procesos",
                            "items": [
                              {
                                "label": "facturaProveedor.xhtml",
                                "routerLink": "/paginas/compras/procesos/facturaProveedor.xhtml"
                              },
                              {
                                "label": "recepcionProveedor.xhtml",
                                "routerLink": "/paginas/compras/procesos/recepcionProveedor.xhtml"
                              }
                            ]
                          },
                          {
                            "label": "Reportes",
                            "items": [
                              {
                                "label": "reporteA.xhtml",
                                "routerLink": "/paginas/compras/Reportes/reporteA.xhtml"
                              },
                              {
                                "label": "reporteB.xhtml",
                                "routerLink": "/paginas/compras/Reportes/reporteB.xhtml"
                              }
                            ]
                          }
                        ]
                      },
                      {
                        "label": "nomina",
                        "items": [
                          {
                            "label": "configuracion",
                            "items": [
                              {
                                "label": "empleados",
                                "items": [
                                  {
                                    "label": "empleado.xhtml",
                                    "routerLink": "/paginas/nomina/configuracion/empleados/empleado.xhtml"
                                  }
                                ]
                              }
                            ]
                          }
                        ]
                      }
                    ]
                  }
                ]
                                
                """;
        JSONAssert.assertEquals(expected, result, JSONCompareMode.STRICT);
    }

    @Test
    void testCreatePageJson() throws JsonProcessingException, JSONException {
        //given
        var list = Arrays.asList("/paginas/compras/procesos/facturaProveedor.xhtml",
                "/paginas/compras/procesos/recepcionProveedor.xhtml",
                "/paginas/compras/Reportes/reporteA.xhtml",
                "/paginas/compras/Reportes/reporteB.xhtml",
                "/paginas/empleado.xhtml"
        );
        //when
        String result = textJsonService.createJson(list);
        System.out.println(result);
        //then
        String expected = """
                [
                  {
                    "label": "paginas",
                    "items": [
                      {
                        "label": "compras",
                        "items": [
                          {
                            "label": "procesos",
                            "items": [
                              {
                                "label": "facturaProveedor.xhtml",
                                "routerLink": "/paginas/compras/procesos/facturaProveedor.xhtml"
                              },
                              {
                                "label": "recepcionProveedor.xhtml",
                                "routerLink": "/paginas/compras/procesos/recepcionProveedor.xhtml"
                              }
                            ]
                          },
                          {
                            "label": "Reportes",
                            "items": [
                              {
                                "label": "reporteA.xhtml",
                                "routerLink": "/paginas/compras/Reportes/reporteA.xhtml"
                              },
                              {
                                "label": "reporteB.xhtml",
                                "routerLink": "/paginas/compras/Reportes/reporteB.xhtml"
                              }
                            ]
                          }
                        ]
                      },
                      {
                        "label": "empleado.xhtml",
                        "routerLink": "/paginas/empleado.xhtml"
                      }
                    ]
                  }
                ]
                                
                """;
        JSONAssert.assertEquals(expected, result, JSONCompareMode.STRICT);
    }

    @Test
    void testCreateTwoRootElementsJson() throws JsonProcessingException, JSONException {
        //given
        var list = Arrays.asList("/paginas/compras/procesos/facturaProveedor.xhtml",
                "/paginas/compras/procesos/recepcionProveedor.xhtml",
                "/paginas/compras/Reportes/reporteA.xhtml",
                "/paginas/compras/Reportes/reporteB.xhtml",
                "/personas/cliente/cliente.xhtml",
                "/personas/provedor/provedor.xhtml"
        );
        //when
        String result = textJsonService.createJson(list);
        System.out.println(result);
        //then
        String expected = """
                [
                  {
                    "label": "paginas",
                    "items": [
                      {
                        "label": "compras",
                        "items": [
                          {
                            "label": "procesos",
                            "items": [
                              {
                                "label": "facturaProveedor.xhtml",
                                "routerLink": "/paginas/compras/procesos/facturaProveedor.xhtml"
                              },
                              {
                                "label": "recepcionProveedor.xhtml",
                                "routerLink": "/paginas/compras/procesos/recepcionProveedor.xhtml"
                              }
                            ]
                          },
                          {
                            "label": "Reportes",
                            "items": [
                              {
                                "label": "reporteA.xhtml",
                                "routerLink": "/paginas/compras/Reportes/reporteA.xhtml"
                              },
                              {
                                "label": "reporteB.xhtml",
                                "routerLink": "/paginas/compras/Reportes/reporteB.xhtml"
                              }
                            ]
                          }
                        ]
                      }
                    ]
                  },
                  {
                    "label": "personas",
                    "items": [
                      {
                        "label": "cliente",
                        "items": [
                          {
                            "label": "cliente.xhtml",
                            "routerLink": "/personas/cliente/cliente.xhtml"
                          }
                        ]
                      },
                      {
                        "label": "provedor",
                        "items": [
                          {
                            "label": "provedor.xhtml",
                            "routerLink": "/personas/provedor/provedor.xhtml"
                          }
                        ]
                      }
                    ]
                  }
                ]   
                """;
        JSONAssert.assertEquals(expected, result, JSONCompareMode.STRICT);
    }


}