package monlau;

import monlau.dao.ProductoDAO;
import monlau.dao.ProductoDAOImpl;
import monlau.model.Producto;
import java.util.List;


public class ProductoManager {
    public static void main(String[] args) {
        ProductoDAO producto = new ProductoDAOImpl();
        ProductoDAOImpl productoImpl = (ProductoDAOImpl) producto;
        
        // 1. CREATE - Insertar un nuevo producto
        System.out.println("\n--- CREATE OPERATION ---");
        Producto nuevoProducto = new Producto(201, "Carne", 15.0);
        producto.insert(nuevoProducto);
        System.out.println("Producto insertado: " + nuevoProducto);
        
        // 2. READ - Leer producto por ID
        System.out.println("\n--- READ OPERATION ---");
        Producto p = producto.read(201);
        System.out.println("Producto leído: " + p);
        
        // 3. UPDATE - Actualizar producto
        System.out.println("\n--- UPDATE OPERATION ---");
        p.setNombre("Carne Premium");
        p.setPrecio(18.5);
        producto.update(p);
        
        // Verificar la actualización
        Producto pActualizado = producto.read(201);
        System.out.println("Producto actualizado: " + pActualizado);
        
        // 4. READ ALL - Leer todos los productos
        System.out.println("\n--- READ ALL OPERATION ---");
        List<Producto> todosProductos = productoImpl.readAll();
        System.out.println("Lista de todos los productos:");
        for (Producto prod : todosProductos) {
            System.out.println(prod);
        }
        

        
        // Verificar la eliminación
        Producto pEliminado = producto.read(201);
        if (pEliminado == null) {
            System.out.println("El producto con ID 201 ha sido eliminado correctamente");
        } else {
            System.out.println("Error: El producto con ID 201 no fue eliminado");
        }
        
        // También podemos probar con el producto original del ejemplo
        System.out.println("\nComprobando producto con ID 200:");
        Producto productoOriginal = producto.read(200);
        System.out.println(productoOriginal != null ? productoOriginal : "No se encontró el producto");
    }
}