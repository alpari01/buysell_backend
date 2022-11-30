package ee.taltech.iti0302.repository;

import ee.taltech.iti0302.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByUserId(Integer userId, Pageable pageable);
}
