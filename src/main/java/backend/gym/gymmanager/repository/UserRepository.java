package backend.gym.gymmanager.repository;

import backend.gym.gymmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByRut(String rut);
}
