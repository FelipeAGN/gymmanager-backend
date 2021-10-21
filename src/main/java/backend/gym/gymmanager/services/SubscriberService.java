package backend.gym.gymmanager.services;

import backend.gym.gymmanager.model.Subscriber;
import backend.gym.gymmanager.model.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface SubscriberService {

    public List<Subscriber> findAll();
    public Subscriber findById(@Min(value = 1L,message = "ID del suscriptor es inválida.") Long id);
    public Subscriber save(@NotNull(message = "El suscriptor no puede ser nulo.")@Valid Subscriber subscriber);
    public void update(@NotNull(message = "El suscriptor no puede ser nulo.")@Valid Subscriber subscriber);
    public void delete(Long id);
}
