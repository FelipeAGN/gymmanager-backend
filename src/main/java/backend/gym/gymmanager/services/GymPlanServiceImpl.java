package backend.gym.gymmanager.services;

import backend.gym.gymmanager.dao.GymPlanRepository;
import backend.gym.gymmanager.dao.PaymentRepository;
import backend.gym.gymmanager.exception.ResourceNotFoundException;
import backend.gym.gymmanager.model.GymPlan;
import backend.gym.gymmanager.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Service
public class GymPlanServiceImpl implements GymPlanService{

    @Autowired
    private GymPlanRepository gymPlanRepository;

    @Override
    public List<GymPlan> findAll() { return (List<GymPlan>) gymPlanRepository.findAll(); }

    @Override
    public GymPlan findById(Long id) { return gymPlanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Plan del cliente no encontrado.")); }

    @Override
    public GymPlan save(@NotNull(message = "El pago no puede ser null.")@Valid GymPlan gymPlan) { return gymPlanRepository.save(gymPlan); }

    @Override
    public void delete(Long id) { gymPlanRepository.deleteById(id);}

    @Override
    public void update(GymPlan gymPlan){this.gymPlanRepository.save(gymPlan);}
}
