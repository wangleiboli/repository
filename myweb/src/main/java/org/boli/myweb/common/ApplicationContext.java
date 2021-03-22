package org.boli.myweb.common;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.boli.myweb.pojo.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * {@link Configuration @Configuration}注解的类等价于XML中配置beans，<br>
 * <p>
 * {@link Configuration @Configuration}注解的类的加载方式：<br>
 * 1.context:component-scan扫描<br>
 * 2.{@link AnnotationConfigApplicationContext}加载<br>
 * 
 * <p>
 * 
 * {@link EnableAsync @EnableAsync}启用异步执行<br>
 * Spring默认情况下，搜索相关的线程池定义：<br>
 * 1.要么在上下文中搜索唯一的{@link org.springframework.core.task.TaskExecutor TaskExecutor}
 * bean，<br>
 * 2.要么搜索名为"taskExecutor"的{@link java.util.concurrent.Executor Executor}
 * bean。<br>
 * 3.如果两者都无法解析，则将使用{@link SimpleAsyncTaskExecutor
 * SimpleAsyncTaskExecutor}来处理异步方法调用。<br>
 *
 */
@Configuration
@ComponentScan("org.boli.myweb")
@EnableAsync
public class ApplicationContext {

	/**
	 * {@link Value @Value}注解属性, 可以赋值properties文件中的配置值<br>
	 * 需要用context:property-placeholder读取properties文件<br>
	 */
	@Value("${id}")
	public String id;

	/**
	 * {@link Bean @Bean}注解的方法的返回对象等价于XML中配置bean，<br>
	 * 
	 * @return
	 */
	@Bean
	public Config config() {
		Config config = new Config();
		config.setId(id);
		return config;
	}

	@Bean("taskExecutor")
	public Executor getAsyncExecutor() {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		return executor;

	}

}
