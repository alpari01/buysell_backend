package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("api/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }
}
