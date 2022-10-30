package ee.taltech.iti0302.models;

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
    private Integer userId;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", insertable=false, updatable=false)
    private User user;
}
