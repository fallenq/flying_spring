package flying.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("flying.mapper.sparrow*")
public class MybatisConfig {
}