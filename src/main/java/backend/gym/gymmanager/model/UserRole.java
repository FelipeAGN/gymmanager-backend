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
@Entity(name = "USER_ROLES")
@Table(name = "USER_ROLES")
public class UserRole {

    @Id
    @Column(name="id_userrole")
    @SequenceGenerator(name="USERROLE_SEQ",sequenceName="USERROLE_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERROLE_SEQ")
    private Integer id_userrole;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_role")
    private Role role;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_user")
    private User user;

    private Date createdAt;
}
