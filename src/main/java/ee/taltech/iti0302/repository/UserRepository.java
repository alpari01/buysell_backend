package ee.taltech.iti0302.repository;

import ee.taltech.iti0302.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
