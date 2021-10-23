package backend.gym.gymmanager;

import backend.gym.gymmanager.model.Role;
import backend.gym.gymmanager.model.User;
import backend.gym.gymmanager.services.RoleService;
import backend.gym.gymmanager.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class GymmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymmanagerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService){
        return args -> {

            Role role1 = new Role();
            role1.setName("SUPER_ADMIN");
            roleService.save(role1);

            Role role2 = new Role();
            role2.setName("ADMIN");
            roleService.save(role2);

            Role role3 = new Role();
            role3.setName("INSTRUCTOR");
            roleService.save(role3);

            User user1 = new User();
            user1.setRut("11111111-1");
            user1.setFirstName("Super");
            user1.setSecondName("Administrador");
            user1.setFullName(user1.getFirstName() + " "+ user1.getSecondName());
            user1.setAddress("Valparaiso");
            user1.setPhoneNumber("912345678");
            user1.setEmail("GYMSUPERADMIN@gmail.com");
            user1.setPassword("1234");
            user1.setCreatedAt(Date.from(Instant.now()));
            user1.setModifiedAt(Date.from(Instant.now()));
            userService.save(user1);

            User user2 = new User();
            user2.setRut("22222222-2");
            user2.setFirstName("Admin");
            user2.setSecondName("Administrador");
            user2.setFullName(user1.getFirstName() + " "+ user1.getSecondName());
            user2.setAddress("Valparaiso");
            user2.setPhoneNumber("912345678");
            user2.setEmail("GYMADMIN@gmail.com");
            user2.setPassword("1234");
            user2.setCreatedAt(Date.from(Instant.now()));
            user2.setModifiedAt(Date.from(Instant.now()));
            userService.save(user2);

            userService.addRoleToUser(user1,role1);
            userService.addRoleToUser(user2,role2);
        };
    }

}
