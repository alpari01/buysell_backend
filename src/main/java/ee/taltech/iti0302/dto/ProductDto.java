package ee.taltech.iti0302.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private Integer userId;
    private String name;
    private String description;
}