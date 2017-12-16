package flying.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// https://gitee.com/baomidou/mybatisplus-spring-boot/tree/master

//@Configuration
@Configuration
@MapperScan("flying.mapper.sparrow")
public class MybatisPlusConfig {
}