package backend.gym.gymmanager.services;

import backend.gym.gymmanager.model.Role;
import backend.gym.gymmanager.repository.RoleRepository;
import backend.gym.gymmanager.repository.UserRepository;
import backend.gym.gymmanager.exception.ResourceNotFoundException;
import backend.gym.gymmanager.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Transactional @Service @RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public User findById(Long id) { return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Suscriptor no encontrado.")); }

    @Override
    public User findByRut(String rut) {
        return userRepository.findByRut(rut);
    }

    @Override
    public User save(@NotNull(message = "El producto no puede ser null.")@Valid User user) { return userRepository.save(user); }

    @Override
    public void delete(Long id) { userRepository.deleteById(id);}

    @Override
    public void update(User user){userRepository.save(user);}

    @Override
    public void addRoleToUser(User user, Role role) {
        User user1 = userRepository.findByRut(user.getRut());
        Role role1 = roleRepository.findByName(role.getName());
        user1.getRoles().add(role1);
    }

}
