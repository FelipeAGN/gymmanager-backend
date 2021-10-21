package backend.gym.gymmanager.services;

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
    public User save(@NotNull(message = "El usuario no puede ser nulo.")@Valid User user);
    public void update(@NotNull(message = "El usuario no puede ser nulo.")@Valid User user);
    public void delete(Long id);

}
