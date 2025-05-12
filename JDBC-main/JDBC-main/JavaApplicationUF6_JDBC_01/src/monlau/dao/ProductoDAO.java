package monlau.dao;

import monlau.model.Producto;
import java.util.List;

public interface ProductoDAO {
    public void insert(Producto producto);
    public void update(Producto producto);
    public void delete(Producto producto);
    public Producto read(Integer id);
    public List<Producto> readAll();
}