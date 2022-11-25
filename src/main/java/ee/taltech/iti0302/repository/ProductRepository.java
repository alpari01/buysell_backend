package ee.taltech.iti0302.repository;

import ee.taltech.iti0302.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
