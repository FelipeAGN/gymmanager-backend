package backend.gym.gymmanager.dao;

import backend.gym.gymmanager.model.GymPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymPlanRepository extends JpaRepository<GymPlan, Long> {
}
