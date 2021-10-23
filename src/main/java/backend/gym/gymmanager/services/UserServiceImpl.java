package backend.gym.gymmanager.services;

import backend.gym.gymmanager.repository.UserRepository;
import backend.gym.gymmanager.exception.ResourceNotFoundException;
import backend.gym.gymmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() { return (List<User>) userRepository.findAll(); }

    @Override
    public User findById(Long id) { return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Suscriptor no encontrado.")); }

    @Override
    public User save(@NotNull(message = "El producto no puede ser null.")@Valid User user) { return userRepository.save(user); }

    @Override
    public void delete(Long id) { userRepository.deleteById(id);}

    @Override
    public void update(User user){this.userRepository.save(user);}

}
