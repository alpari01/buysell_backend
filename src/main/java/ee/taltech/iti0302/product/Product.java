package ee.taltech.iti0302.product;

public class Product {

    private Integer id;
    private Integer userId;
    private String name;
    private Integer type;
    private String description;
    private String status;

    public Product(Integer id, Integer userId, String name, Integer type, String description, String status) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
