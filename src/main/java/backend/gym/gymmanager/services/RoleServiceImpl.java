package backend.gym.gymmanager.services;

import backend.gym.gymmanager.dao.RoleRepository;
import backend.gym.gymmanager.dao.UserRepository;
import backend.gym.gymmanager.exception.ResourceNotFoundException;
import backend.gym.gymmanager.model.Role;
import backend.gym.gymmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() { return (List<Role>) roleRepository.findAll(); }

    @Override
    public Role findById(Long id) { return roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Rol no encontrado.")); }

    @Override
    public Role save(@NotNull(message = "El rol no puede ser null.")@Valid Role role) { return roleRepository.save(role); }

    @Override
    public void delete(Long id) { roleRepository.deleteById(id);}

    @Override
    public void update(Role role){this.roleRepository.save(role);}
}
