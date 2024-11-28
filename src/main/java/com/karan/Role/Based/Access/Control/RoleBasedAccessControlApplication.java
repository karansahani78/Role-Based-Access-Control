package com.karan.Role.Based.Access.Control;

import com.karan.Role.Based.Access.Control.Model.Role;
import com.karan.Role.Based.Access.Control.Model.User;
import com.karan.Role.Based.Access.Control.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories("com.karan.RBAC.Repository")
public class RoleBasedAccessControlApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedAccessControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null==adminAccount){
			User user = new User();

			user.setEmail("sohanyadav238@gamil.com");
			user.setFirstName("sohan");
			user.setLastName("yadav");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}

