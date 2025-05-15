
package org.example.democrudproducto.repository;

import java.util.List;

import org.example.democrudproducto.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductoRepository {

    private JdbcTemplate plantilla;

    public ProductoRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    @Transactional
    public void insertar(Producto producto) {
        plantilla.update("insert into Productos (nombre, descripcion, precio, stock) values (?,?,?,?)",
                producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getStock());
    }

    public List<Producto> buscarTodos() {
        return plantilla.query("select * from Productos", new ProductoMapper());
    }

    public Producto buscarUno(String nombre) {
        List<Producto> resultados = plantilla.query("select * from Productos where nombre=?", new ProductoMapper(), nombre);
        if (resultados.isEmpty()) {
            System.out.println("No se encontró ningún resultado para: " + nombre);
            return null;
        } else {
            System.out.println("Encontrado: " + resultados.get(0).getNombre());
            return resultados.get(0);
        }
    }

    @Transactional
    public void actualizar(Producto producto) {
        plantilla.update("update Productos set descripcion=?, precio=?, stock=? where nombre=?",
                producto.getDescripcion(), producto.getPrecio(), producto.getStock(), producto.getNombre());
    }

    @Transactional
    public void borrar(Producto producto) {
        plantilla.update("delete from Productos where nombre=?", producto.getNombre());
    }

    @Transactional
    public void borrarTodos() {
        plantilla.update("delete from Productos");
    }
}