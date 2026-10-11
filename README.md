# Examen T2 - Grupo 8

**Curso:** PROG04697 - Desarrollo de Aplicaciones Web II | **Ciclo:** Sexto

## Integrantes
- Yaxon Paul Calle Castillo
- Yuly Gisela Huanca Tito
- Brayan Javier Jara Rojas
- Nicole Eimi Nolasco Zaan
- Cesar Roman Quispe

---

## Descripción del Proyecto (PAGOYA Perú)
Solución backend basada en una arquitectura de microservicios para la gestión de tarjetas prepago, estructurada de la siguiente manera:

### 1. Eureka Server (`eureka-server` - Puerto 8761)
- Servidor central de descubrimiento, registro y monitoreo de los microservicios.

### 2. Microservicio de Reclamos (`ms-reclamos` - Puerto 8081)
- Gestión de reclamos por consumos desconocidos en tarjetas prepago.
- **Campos principales:** `numreclamo`, `fechareclamo`, `nomcliente`, `ultimos4tarjeta`, `motivo`, `analista` (por defecto "No asignado"), `estado` (por defecto 1 - pendiente) y `observacion` (por defecto "por evaluar").
- **Funcionalidades:** Registro, consulta por número y actualización de reclamos.

### 3. Microservicio de Resolución (`ms-resolucion` - Puerto 8085)
- Automatización del proceso de resolución a cargo del área de riesgos.
- **Comunicación:** Integración con `ms-reclamos` mediante **Spring Cloud OpenFeign** para validar la existencia del reclamo.
- **Acciones:** Actualiza el estado a 2 (procedente) o 3 (improcedente), registra el nombre del analista y modifica la observación, retornando los mensajes de éxito o error correspondientes.

---

## Tecnologías Utilizadas
- **Java & Spring Boot 3.3.4**
- **Spring Cloud Netflix Eureka**
- **Spring Cloud OpenFeign**
- **MySQL & Spring Data JPA**
- **Postman** (Pruebas de endpoints REST)
