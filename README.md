# RETO ASINFO

## Objetivo
>Generar un JSON a partir de una lista de textos, el cual representa un menú
La aplicación debe cumplir con los siguientes lineamientos:
• Lenguaje de programación *JAVA*

## Actividad
Dado
```java
List<String> lista = new ArrayList<>();
lista.add("/paginas/compras/procesos/facturaProveedor.xhtml");
lista.add("/paginas/compras/procesos/recepcionProveedor.xhtml");
lista.add("/paginas/compras/Reportes/reporteA.xhtml");
lista.add("/paginas/compras/Reportes/reporteB.xhtml");
lista.add("/paginas/nomina/configuracion/empleados/empleado.xhtml");
```
## Resultado
```json
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
```