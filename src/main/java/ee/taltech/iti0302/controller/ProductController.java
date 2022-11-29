package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.repository.ProductFilter;
import ee.taltech.iti0302.repository.ProductResponse;
import ee.taltech.iti0302.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/api/products")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @DeleteMapping("/api/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Integer id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/api/products2")
    public ProductResponse getProducts2(int page, String orderBy, String name) {
        ProductFilter filter = new ProductFilter(page, orderBy, name);
        return productService.search(filter);
    }
}
