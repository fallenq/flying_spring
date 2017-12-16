package flying.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.toolkit.PluginUtils;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;

// https://gitee.com/baomidou/mybatisplus-spring-boot/tree/master

//@Configuration
@MapperScan("com.baomidou.springboot.mapper*")
public class MybatisPlusConfig {
	
    @Autowired
    private DruidDataSource dataSource;

	/**
	 * mybatis-plus SQL执行效率插件【生产环境可以关闭】
	 */
//	@Bean
//	public PerformanceInterceptor performanceInterceptor() {
//		return new PerformanceInterceptor();
//	}
    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

	public GlobalConfiguration globalConfiguration() {
		// MP 全局配置，更多内容进入类看注释
		GlobalConfiguration globalConfig = new GlobalConfiguration();
		globalConfig.setDbType(DBType.MYSQL.name());// 数据库类型
		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID")
		// UUID->`3`("全局唯一ID")
		globalConfig.setIdType(2);
		// globalConfig.setSqlInjector(new
		// com.baomidou.mybatisplus.mapper.AutoSqlInjector());
		// 逻辑删除
//		globalConfig.setSqlInjector(new com.baomidou.mybatisplus.mapper.LogicSqlInjector());
		globalConfig.setLogicDeleteValue("-1");
		globalConfig.setLogicNotDeleteValue("1");
		// MP 属性下划线 转 驼峰 , 如果原生配置 mc.setMapUnderscoreToCamelCase(true) 开启，该配置可以无。
		globalConfig.setDbColumnUnderline(true);
		return globalConfig;
	}

//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "basisDataSource") DruidDataSource dataSource) throws Exception {
//        log.info("初始化SqlSessionFactory");
//        String mapperLocations = "classpath:db-ason/sql/**/*.xml";
//        String configLocation = "classpath:db-ason/mybatis/mybatis-sqlconfig.xml";
//        String typeAliasesPackage = "com.ason.entity.**";
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource); //数据源
//        sqlSessionFactory.setGlobalConfig(globalConfig); //全局配置
//        Interceptor[] interceptor = {new PaginationInterceptor()};
//        sqlSessionFactory.setPlugins(interceptor); //分页插件
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            //自动扫描Mapping.xml文件
//            sqlSessionFactory.setMapperLocations(resolver.getResources(mapperLocations));
//            sqlSessionFactory.setConfigLocation(resolver.getResource(configLocation));
//            sqlSessionFactory.setTypeAliasesPackage(typeAliasesPackage);
//            return sqlSessionFactory.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }

}