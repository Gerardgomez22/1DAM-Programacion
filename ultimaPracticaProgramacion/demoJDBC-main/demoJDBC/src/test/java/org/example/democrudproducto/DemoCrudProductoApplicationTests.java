package org.example.democrudproducto;

import org.example.democrudproducto.model.Producto;
import org.example.democrudproducto.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Sql({"/schema.sql"})
class DemoCrudProductoApplicationTests {

    @Autowired
    ProductoRepository repositorio;

    @Test
    void contextLoads() {
    }

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        repositorio.borrarTodos(); // Asegurarse de comenzar con tabla vacía

        Producto producto = new Producto("Laptop", "Laptop gaming", 1200.50, 10);
        repositorio.insertar(producto);

        producto = new Producto("Smartphone", "Smartphone de última generación", 800.99, 20);
        repositorio.insertar(producto);

        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        repositorio.borrarTodos();

        Producto producto1 = new Producto("Laptop", "Laptop gaming", 1200.50, 10);
        repositorio.insertar(producto1);

        Producto producto2 = new Producto("Smartphone", "Smartphone de última generación", 800.99, 20);
        repositorio.insertar(producto2);

        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarUno() {
        repositorio.borrarTodos();

        Producto producto = new Producto("Laptop", "Laptop gaming", 1200.50, 10);
        repositorio.insertar(producto);

        Producto productoEncontrado = repositorio.buscarUno("Laptop");
        assertNotNull(productoEncontrado);
        assertEquals("Laptop", productoEncontrado.getNombre());
        assertEquals("Laptop gaming", productoEncontrado.getDescripcion());
        assertEquals(1200.50, productoEncontrado.getPrecio());
        assertEquals(10, productoEncontrado.getStock());
    }

    @Test
    void borrarProducto() {
        repositorio.borrarTodos();

        Producto producto1 = new Producto("Laptop", "Laptop gaming", 1200.50, 10);
        repositorio.insertar(producto1);

        Producto producto2 = new Producto("Smartphone", "Smartphone de última generación", 800.99, 20);
        repositorio.insertar(producto2);

        Producto productoBorrar = new Producto("Laptop");
        repositorio.borrar(productoBorrar);

        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());

        Producto productoEliminado = repositorio.buscarUno("Laptop");
        assertNull(productoEliminado);
    }

    @Test
    void actualizarProducto() {
        repositorio.borrarTodos();

        Producto producto = new Producto("Laptop", "Laptop gaming", 1200.50, 10);
        repositorio.insertar(producto);

        // Actualizar producto
        Producto productoActualizado = new Producto("Laptop", "Laptop profesional actualizado", 1500.99, 5);
        repositorio.actualizar(productoActualizado);

        // Verificar actualización
        Producto productoVerificar = repositorio.buscarUno("Laptop");
        assertNotNull(productoVerificar);
        assertEquals("Laptop profesional actualizado", productoVerificar.getDescripcion());
        assertEquals(1500.99, productoVerificar.getPrecio());
        assertEquals(5, productoVerificar.getStock());
    }
}