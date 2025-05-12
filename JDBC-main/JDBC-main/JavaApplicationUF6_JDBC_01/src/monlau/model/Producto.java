package monlau.model;

// Si estás usando Lombok, conserva estas anotaciones
// De lo contrario, las he reemplazado con implementaciones manuales
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    
    // Constructor vacío
    public Producto() {
    }
    
    // Constructor con todos los campos
    public Producto(Integer id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Getters y setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    // toString para mostrar información del producto
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre='" + nombre + "', precio=" + precio + "}";
    }
}