package backend.gym.gymmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "SUBSCRIBERS")
@Table(name = "SUBSCRIBERS")
public class Subscriber extends Person{

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "gymplan_id")
    private GymPlan gymPlan;

    @OneToMany(mappedBy="subscriber", fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<SubscriberPayments> subscriberPayments;


}
