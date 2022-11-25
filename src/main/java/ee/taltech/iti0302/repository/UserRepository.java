package ee.taltech.iti0302.repository;

import ee.taltech.iti0302.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    // TODO
    Optional<User> findById(Integer integer);
}
