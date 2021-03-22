package org.boli.myweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.boli.myweb.common.MyTask;
import org.boli.myweb.entity.User;
import org.boli.myweb.model.Model;
import org.boli.myweb.pojo.Config;
import org.boli.myweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

/**
 * {@link Component @Component}注解的类，相当于xml中配置的bean<br>
 * Spring提供了{@link Component @Component}的三个衍生注解<br>
 * {@link Controller @Controller}通常用于Controller类，也就是控制层<br>
 * {@link Service @Service}通常用于注解Service类，也就是服务层<br>
 * {@link Repository @Repository}通常用于注解DAO类，也就是我们常说的持久层<br>
 * 
 * <p>
 * 另见JSR(Java规范提案)的{@link Named @Named}<br>
 * 功能与{@link Component @Component}相当<br>
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * Spring的注解，可以作用在变量、setter方法、构造函数上<br>
	 * {@link Autowired @Autowired}自动注入策略默认顺序：byType > byName<br>
	 * 1.byType：出现多个bean候选者时,被{@link Primary @Primary}注解的bean将作为首选者， <br>
	 * 2.byName：找到则装配，找不到则报错<br>
	 * 
	 * <p>
	 * 属性或者setter被{@link Qualifier @Qualifier(value = "**")}注解时，指明按照byName策略进行注入<br>
	 * 1.查找名称为**的同类型bean，找到则装配，找不到则报错<br>
	 * 
	 * <p>
	 * 参数required默认为true，找不到就会报错；置为false后，找不到会置为null
	 * 
	 * <p>
	 * 另见JSR的{@link Resource @Resource}和{@link Inject @Inject}
	 */
	@Autowired(required = true)
	@Qualifier(value = "userServiceImpl")
	UserService userService;

	/**
	 * J2EE的注解，可以作用在变量、setter方法、构造函数上<br>
	 * {@link Resource @Resource}自动注入策略默认顺序：byName > byType<br>
	 * 使用name属性指明按照byName策略进行注入<br>
	 * 使用type属性指明按照byType策略进行注入<br>
	 */
	@Resource(type = MyTask.class)
	MyTask myTask;

	/**
	 * J2EE的注解，可以作用在变量、setter方法、构造函数上<br>
	 * {@link Inject @Inject}自动注入策略默认： byType<br>
	 * 和{@link Named @Named}结合使用时，自动注入策略变成byName
	 * 
	 */
	@Inject
	@Named("config")
	Config config;

	/**
	 * {@link RequestMapping @RequestMapping}映射请求<br>
	 * <p>
	 * {@link ResponseBody @ResponseBody}将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public PageInfo<User> queryAll() {

		logger.info("config properties [id] = {}", config.getId());

		myTask.startMyTask();

		return userService.selectAll();

	}

	/**
	 * 1.1.零散参数根据name自动装配
	 */
	@RequestMapping("/selectById")
	@ResponseBody
	public User selectById(long id) {

		return userService.selectById(id);

	}

	/**
	 * 1.2.零散参数name不一致
	 * {@link RequestParam @RequestParam}:当表单元素与控制器方法的参数不匹配的情况下，使用此注解声明参数名称。
	 */
	@RequestMapping("/selectByNum")
	@ResponseBody
	public User selectByNum(@RequestParam("num") long id) {

		return userService.selectById(id);

	}

	/**
	 * 2.对象自动装配<br>
	 * id -> user.id
	 */
	@RequestMapping("/select")
	@ResponseBody
	public List<User> select(User user) {

		return userService.select(user);

	}

	/**
	 * 3.域属性自动装配 <br>
	 * user.id -> model.user.id
	 */
	@RequestMapping("/selectByModel")
	@ResponseBody
	public List<User> selectByModel(Model model) {

		return userService.select(model.getUser());

	}

	/**
	 * 4.集合自动装配 <br>
	 * users[0].id -> model.users[0].id
	 */
	@RequestMapping("/selectByList")
	@ResponseBody
	public List<User> selectByList(Model model) {

		return userService.select(model.getUsers().get(0));

	}

	/**
	 * 5.RESTFUL风格的参数传递<br>
	 * {@link PathVariable @PathVariable}:映射地址中的参数。
	 */
	@RequestMapping("/get/{id}")
	@ResponseBody
	public User get(@PathVariable long id) {

		return userService.selectById(id);

	}

	/**
	 * Spring容器初始化bean和销毁前所做的操作定义方式有三种：<br>
	 * 1.通过{@link PostConstruct @PostConstruct}和{@link PreDestroy @PreDestroy}注解<br>
	 * 2.通过在xml中定义init-method和 destory-method方法<br>
	 * 3.通过bean实现{@link InitializingBean InitializingBean}和 {@link DisposableBean
	 * DisposableBean}接口<br>
	 * 
	 * <p>
	 * 但他们之前并不等价。即使3个方法都用上了，也有先后顺序：<br>
	 * Constructor > @PostConstruct > InitializingBean > init-method<br>
	 * 
	 * <p>
	 * 初始化bean的操作，只能有一个方法可以用此注释进行注释，方法不能有参数，返回值必需是void,方法需要是非静态的。
	 */
	@PostConstruct
	public void init() {
		System.out.println(String.format("初始化bean[%s]", this.getClass().toString()));
	}

	/**
	 * 销毁bean前的操作，只能有一个方法可以用此注释进行注释，方法不能有参数，返回值必需是void,方法需要是非静态的。
	 */
	@PreDestroy
	public void dostory() {
		System.out.println(String.format("销毁bean[%s]", this.getClass().toString()));
	}
}
