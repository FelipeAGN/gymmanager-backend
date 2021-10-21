package backend.gym.gymmanager.services;

import backend.gym.gymmanager.model.Role;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface RoleService {

    public List<Role> findAll();
    public Role findById(@Min(value = 1L,message = "ID del rol es inválida.") Long id);
    public Role save(@NotNull(message = "El rol no puede ser nulo.")@Valid Role role);
    public void update(@NotNull(message = "El rol no puede ser nulo.")@Valid Role role);
    public void delete(Long id);
}
