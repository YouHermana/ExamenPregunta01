package ExamenT1Oswaldo;

import java.util.Scanner;
import java.time.LocalDate;

public class TestPregunta01 {
    public String registrarDevolucion(String codigoDev, String codigoProd,
                                      String nombreCliente, String motivo,
                                      LocalDate fechaCompra, LocalDate fechaDev) {

        // Validar campos vacíos
        if (codigoDev == null || codigoProd == null || nombreCliente == null
                || motivo == null || fechaCompra == null || fechaDev == null
                || codigoDev.isEmpty() || codigoProd.isEmpty()
                || nombreCliente.isEmpty() || motivo.isEmpty()) {
            return "Debe ingresar todos los datos requeridos";
        }

        // Validar código de devolución
        if (!codigoDev.matches("D\\d{4}")) {
            return "Ingrese un código de devolución válido";
        }

        // Validar código de producto
        if (!codigoProd.matches("[A-Za-z0-9]{6}")) {
            return "Ingrese un código de producto válido";
        }

        // Validar nombre del cliente
        if (!nombreCliente.matches("[A-Za-z]{4,}")) {
            return "El nombre del cliente debe tener al menos cuatro caracteres alfabéticos";
        }

        // Validar motivo
        if (motivo.length() < 10) {
            return "El motivo de la devolución debe tener al menos diez caracteres";
        }

        // Validar fechas
        if (fechaDev.isBefore(fechaCompra) || fechaDev.isAfter(LocalDate.now())) {
            return "Ingrese una fecha de devolución válida";
        }

        // Todo correcto
        return "La devolución ha sido registrada correctamente";
    }
}