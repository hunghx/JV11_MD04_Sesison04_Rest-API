package ra.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import ra.api.model.entity.Role;
import ra.api.model.entity.RoleName;
import ra.api.model.entity.User;
import ra.api.repository.IRoleRepository;
import ra.api.repository.IUserRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class RestFulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFulApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // cấu hinhd swagger
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:9999");
        devServer.setDescription("Server URL in Development environment");
        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:9999");
        prodServer.setDescription("Server URL in Production environment");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }

    @Bean
    public CommandLineRunner runner(PasswordEncoder passwordEncoder, IUserRepository userRepository, IRoleRepository roleRepository){

        return args -> {
//            Role u = new Role(null, RoleName.USER);
//            Role a = new Role(null, RoleName.ADMIN);
//            Role m = new Role(null, RoleName.MANAGER);
//            roleRepository.save(u);
//            roleRepository.save(a);
//            roleRepository.save(m);
//
//            User s1 = new User(null,"admin","admin@gmail.com",null, "admin123",null, null, null, LocalDate.now(), null, true, false, new HashSet<>());
//            User s2 = new User(null,"hunghx","hung@gmail.com","Ho Xuan Hung", "123456$",null, "09783454356", "HCM", LocalDate.now(), null, true, false, new HashSet<>());
//            s1.getRoleSet().add(roleRepository.findById(1L).orElseThrow());
//            s1.getRoleSet().add(roleRepository.findById(2L).orElseThrow());
//            s1.getRoleSet().add(roleRepository.findById(3L).orElseThrow());
//            s2.getRoleSet().add(roleRepository.findById(1L).orElseThrow());
//            userRepository.save(s1);
//            userRepository.save(s2);
            System.out.println(passwordEncoder.encode("admin123"));
            System.out.println(passwordEncoder.encode("123456"));
        };
    }
}
