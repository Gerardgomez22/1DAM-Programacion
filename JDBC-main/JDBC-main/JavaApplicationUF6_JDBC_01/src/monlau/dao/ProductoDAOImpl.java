package monlau.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import monlau.model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProductoDAOImpl implements ProductoDAO {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/inventario?useSSL=false";
    static final String DB_USR = "root";
    static final String DB_PWD = "";

    /**
     * Load the driver class
     */
    private void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: failed to load MySQL JDBC Driver");
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Producto producto) {
        Connection conn = null;
        try {
            registerDriver();
            // abrir la conexión
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            Statement stmt = conn.createStatement();
            // enviar el comando insert
            int i = stmt.executeUpdate("insert into producto values (" + producto.getId() + ",'" + producto.getNombre() + "'," + producto.getPrecio() + ");");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Producto producto) {
        Connection conn = null;
        try {
            registerDriver();
            // abrir la conexión
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            
            // usar PreparedStatement para evitar SQL Injection
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?")) {
                ps.setString(1, producto.getNombre());
                ps.setDouble(2, producto.getPrecio());
                ps.setInt(3, producto.getId());
                
                int filasActualizadas = ps.executeUpdate();
                if (filasActualizadas == 0) {
                    System.err.println("No se encontró ningún producto con ID: " + producto.getId());
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Producto producto) {
        Connection conn = null;
        try {
            registerDriver();
            // abrir la conexión
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            
            // usar PreparedStatement para evitar SQL Injection
            try (PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM producto WHERE id = ?")) {
                ps.setInt(1, producto.getId());
                
                int filasEliminadas = ps.executeUpdate();
                if (filasEliminadas == 0) {
                    System.err.println("No se encontró ningún producto con ID: " + producto.getId());
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Producto read(Integer id) {
        Connection conn = null;
        Producto prod = null;
        try {
            registerDriver();
            // abrir la conexión
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            // consulta select (selecciona el producto con id especificado)
            try (PreparedStatement ps = conn.prepareStatement("select * from producto where id = ?")) {
                //indicar el id que buscamos
                ps.setInt(1, id);
                //ejecutar la consulta
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de las columnas y mapearlas a la clase Product
                        prod = new Producto(id, rs.getString("nombre"), rs.getDouble("precio"));
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return prod;
    }
    
    // Método adicional para listar todos los productos
    public List<Producto> readAll() {
        Connection conn = null;
        List<Producto> productos = new ArrayList<>();
        
        try {
            registerDriver();
            // abrir la conexión
            conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
            
            // consulta select para todos los productos
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM producto")) {
                
                while (rs.next()) {
                    Producto prod = new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio")
                    );
                    productos.add(prod);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return productos;
    }
}