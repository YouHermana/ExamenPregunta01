package ExamenT1Oswaldo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TestPregunta01Test {
    TestPregunta01 service = new TestPregunta01();
    @Test
    void deberiaRetornarErrorSiHayCamposVacios() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "", "", "", "", null, null
        );

        assertEquals("Debe ingresar todos los datos requeridos", resultado);
    }

    @Test
    void deberiaValidarCodigoDevolucion() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "12345", "ABC123", "Juan", "Producto defectuoso",
                LocalDate.now(), LocalDate.now()
        );

        assertEquals("Ingrese un código de devolución válido", resultado);
    }

    @Test
    void deberiaValidarCodigoProducto() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "D1234", "ABC12", "Juan", "Producto defectuoso",
                LocalDate.now(), LocalDate.now()
        );

        assertEquals("Ingrese un código de producto válido", resultado);
    }

    @Test
    void deberiaValidarNombreCliente() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "D1234", "ABC123", "J1", "Producto defectuoso",
                LocalDate.now(), LocalDate.now()
        );

        assertEquals("El nombre del cliente debe tener al menos cuatro caracteres alfabéticos", resultado);
    }

    @Test
    void deberiaValidarMotivo() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "D1234", "ABC123", "Juan", "Malo",
                LocalDate.now(), LocalDate.now()
        );

        assertEquals("El motivo de la devolución debe tener al menos diez caracteres", resultado);
    }

    @Test
    void deberiaValidarFechas() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "D1234", "ABC123", "Juan", "Producto defectuoso",
                LocalDate.now(), LocalDate.now().minusDays(1)
        );

        assertEquals("Ingrese una fecha de devolución válida", resultado);
    }

    @Test
    void deberiaRegistrarCorrectamente() {
        TestPregunta01 service = new TestPregunta01();

        String resultado = service.registrarDevolucion(
                "D1234", "ABC123", "Juan",
                "Producto defectuoso en pantalla",
                LocalDate.now().minusDays(2),
                LocalDate.now()
        );

        assertEquals("La devolución ha sido registrada correctamente", resultado);
    }
}