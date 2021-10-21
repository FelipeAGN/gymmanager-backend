package backend.gym.gymmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "SUBSCRIBER_PAYMENTS")
@Table(name = "SUBSCRIBER_PAYMENTS")
public class SubscriberPayments {

    @Id
    @Column(name="id_subscriberpayment")
    @SequenceGenerator(name="SUBSCRIBERPAYMENT_SEQ",sequenceName="SUBSCRIBERPAYMENT_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SUBSCRIBERPAYMENT_SEQ")
    private Integer id_subscriberpayment;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_subscriber")
    private Subscriber subscriber;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_payment")
    private Payment payment;

    private Date createdAt;
}
