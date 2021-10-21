package backend.gym.gymmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum GymPlanification {

    STUDENT(0),
    BASIC(1),
    INTERMEDIATE(2),
    PRO(3);

    private Integer valueGymPlanification;

    public static GymPlanification fromValue(Integer value){
        for(GymPlanification gymPlanification: GymPlanification.values()){
            if(gymPlanification.valueGymPlanification.equals(value)){
                return gymPlanification;
            }
        }
        return null;
    }
}
