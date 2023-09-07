package com.management.customer.repository.master;

import com.management.customer.entity.master.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
