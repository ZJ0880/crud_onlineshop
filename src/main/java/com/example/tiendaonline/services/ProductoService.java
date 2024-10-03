package com.example.tiendaonline.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tiendaonline.models.Producto;
import com.example.tiendaonline.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Guardar un nuevo producto
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener un producto por ID
    public Producto obtenerPorId(Long id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        return optionalProducto.orElse(null); // Devuelve null si no se encuentra
    }

    //Actualizar un producto por ID
    public Producto actualizar(Long id, Producto productoActualizado) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        
        if (optionalProducto.isPresent()) {
            Producto productoExistente = optionalProducto.get();
            
            // Actualizar los campos del producto
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            productoExistente.setStock(productoActualizado.getStock());
            
            // Guardar el producto actualizado
            return productoRepository.save(productoExistente);
        }
        
        return null; // Si no se encuentra el producto
    }

    // Eliminar un producto por ID
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
