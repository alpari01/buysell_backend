package ee.taltech.iti0302.product;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private String userFirstName;
    private String userLastName;
}
