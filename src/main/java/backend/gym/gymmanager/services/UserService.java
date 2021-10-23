package backend.gym.gymmanager.services;

import backend.gym.gymmanager.model.Role;
import backend.gym.gymmanager.model.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface UserService {

    public List<User> findAll();
    public User findById(@Min(value = 1L,message = "ID del usuario es inválida.") Long id);
    public User findByRut(@Min(value = 1L,message = "RUT del usuario es inválido.") String rut);
    public User save(@NotNull(message = "El usuario no puede ser nulo.")@Valid User user);
    void update(@NotNull(message = "El usuario no puede ser nulo.")@Valid User user);
    void delete(Long id);
    void addRoleToUser(User user, Role role);

}
