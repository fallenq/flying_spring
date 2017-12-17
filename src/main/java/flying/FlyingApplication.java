package flying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("flying.mapper.sparrow*")
public class FlyingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyingApplication.class, args);
	}
}
