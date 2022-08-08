import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication(scanBasePackages="com.xsw.construct")
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
