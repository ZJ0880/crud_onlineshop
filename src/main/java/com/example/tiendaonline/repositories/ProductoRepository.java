package com.example.tiendaonline.repositories;

import com.example.tiendaonline.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
