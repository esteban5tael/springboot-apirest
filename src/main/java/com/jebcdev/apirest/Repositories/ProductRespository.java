package com.jebcdev.apirest.Repositories;

import com.jebcdev.apirest.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product,Long> {
}
