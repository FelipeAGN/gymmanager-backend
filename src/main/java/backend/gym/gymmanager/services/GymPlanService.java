package backend.gym.gymmanager.services;

import backend.gym.gymmanager.model.GymPlan;
import backend.gym.gymmanager.model.Payment;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface GymPlanService {

    public List<GymPlan> findAll();
    public GymPlan findById(@Min(value = 1L,message = "ID del plan del usuario no es válida.") Long id);
    public GymPlan save(@NotNull(message = "El plan del usuario no puede ser nulo.")@Valid GymPlan gymPlan);
    public void update(@NotNull(message = "El plan del usuario no puede ser nulo.")@Valid GymPlan gymPlan);
    public void delete(Long id);
}
