package fmi.pserasmusip;


        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.web.support.SpringBootServletInitializer;
        import org.springframework.context.annotation.Bean;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class PserasmusipApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {

        SpringApplication.run(PserasmusipApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
    }



}