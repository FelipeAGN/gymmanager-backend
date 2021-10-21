package backend.gym.gymmanager.services;

import backend.gym.gymmanager.model.Payment;
import backend.gym.gymmanager.model.Role;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface PaymentService {

    public List<Payment> findAll();
    public Payment findById(@Min(value = 1L,message = "ID del pago es inválida.") Long id);
    public Payment save(@NotNull(message = "El pago no puede ser nulo.")@Valid Payment payment);
    public void update(@NotNull(message = "El pago no puede ser nulo.")@Valid Payment payment);
    public void delete(Long id);
}
