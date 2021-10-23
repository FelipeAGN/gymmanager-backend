package backend.gym.gymmanager.services;

import backend.gym.gymmanager.repository.SubscriberRepository;
import backend.gym.gymmanager.exception.ResourceNotFoundException;
import backend.gym.gymmanager.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Service
public class SubscriberServiceImpl implements SubscriberService{

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public List<Subscriber> findAll() { return (List<Subscriber>) subscriberRepository.findAll(); }

    @Override
    public Subscriber findById(Long id) { return subscriberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Suscriptor no encontrado.")); }

    @Override
    public Subscriber save(@NotNull(message = "El producto no puede ser null.")@Valid Subscriber subscriber) { return subscriberRepository.save(subscriber); }

    @Override
    public void delete(Long id) { subscriberRepository.deleteById(id);}

    @Override
    public void update(Subscriber subscriber){this.subscriberRepository.save(subscriber);}
}
