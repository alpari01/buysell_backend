package ee.taltech.iti0302.repository;

import lombok.Data;

@Data
public class ProductFilter {

    private String name;
    private String orderBy;
    private String order;
    private int firstResult;

    public ProductFilter(int page, String orderBy, String name) {
        this.name = name;
        this.orderBy = orderBy;
        this.firstResult = page;
        this.order = "ASC";
    }
}
