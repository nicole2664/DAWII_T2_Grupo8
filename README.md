# Examen T2 - Grupo 8

**Curso:** PROG04697 - Desarrollo de Aplicaciones Web II | **Ciclo:** Sexto

## Integrantes

- Nicole Eimi Nolasco Zaan
- Yuly Gisela Huanca Tito
- Brayan Javier Jara Rojas
- Yaxon Paul Calle Castillo
- Cesar Roman Quispe

## Descripción del Proyecto (PAGOYA Perú)
Solución backend desarrollada bajo una arquitectura de microservicios para la gestión de tarjetas prepago, la cual incluye:
- **Eureka Server:** Servidor de descubrimiento y registro (Puerto 8761).
- **Microservicio de Reclamos (`ms-reclamos`):** Gestión, registro y consulta de reclamos de clientes (Puerto 8081).
- **Microservicio de Resolución (`ms-resolucion`):** Automatización de dictámenes y validaciones conectadas mediante Spring Cloud OpenFeign (Puerto 8085).

## Tecnologías Utilizadas
- **Java & Spring Boot 3.3.4**
- **Spring Cloud Netflix Eureka**
- **Spring Cloud OpenFeign**
- **MySQL & Spring Data JPA**
- **Postman** (Pruebas de endpoints REST)
