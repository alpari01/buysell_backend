package ee.taltech.iti0302.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthdate;
    private String gender;

    @OneToMany(mappedBy = "user")
    private List<Product> products;
}
