package backend.gym.gymmanager.services;

import backend.gym.gymmanager.repository.PaymentRepository;
import backend.gym.gymmanager.exception.ResourceNotFoundException;
import backend.gym.gymmanager.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAll() { return (List<Payment>) paymentRepository.findAll(); }

    @Override
    public Payment findById(Long id) { return paymentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pago no encontrado.")); }

    @Override
    public Payment save(@NotNull(message = "El pago no puede ser null.")@Valid Payment payment) { return paymentRepository.save(payment); }

    @Override
    public void delete(Long id) { paymentRepository.deleteById(id);}

    @Override
    public void update(Payment payment){this.paymentRepository.save(payment);}
}
