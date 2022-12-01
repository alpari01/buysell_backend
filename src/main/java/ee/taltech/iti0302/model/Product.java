package ee.taltech.iti0302.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String name;
    private String description;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "trade_id", insertable=false, updatable=false)
    private Integer tradeId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable=false, updatable=false)
    private ProductCategory productCategory;

    @OneToOne
    private Trade trade;
}
