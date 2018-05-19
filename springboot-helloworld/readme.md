# springboot 源码分析

## SpringBootApplication

    @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
    
    @Configuration注解(可以理解为xml里面的<beans>标签)，一般和@Bean注解(可以理解为xml里面的<bean>标签)搭配使用。使用这2个注解可以创建一个配置类
    
    @EnableAutoConfiguration注解自动载入应用程序所需要的所有Bean，这依赖于SpringBoot在类路径中的查找
    
    @EnableAutoConfiguration注解使用@Import注解导入EnableAutoConfigurationImportSelector类，此类继承了AutoConfigurationImportSelector类，而AutoConfigurationImportSelector类的selectImports方法就是关键所在
    
    可以看出，该方法使用了Spring Core包的SpringFactoriesLoader类的loadFactoryNames方法，该方法会查询classpath下的JAR文件中包含的/META/spring.factories文件，从文件中读取配置文件名(这里是org.springframework.boot.autoconfigure.EnableAutoConfiguration)的属性，例如
    
    在jar:file:/C:/Users/guiqingqing/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.5.6.RELEASE/spring-boot-autoconfigure-1.5.6.RELEASE.jar!/META-INF/spring.factories文件找到如下配置
    
    获取自动配置的类之后调用removeDuplicates方法先去除重复，然后调用sort方法进行排序，接下来调用getExclusions方法获取配置的exclude(不包含)的类，比如@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})，然后这些exclude的类也会被排除
    
    然后是调用filter方法，该方法决定哪些bean自动配置，哪些不配置。去classpath下的JAR文件中包含的/META/spring.factories文件里查询org.springframework.boot.autoconfigure.AutoConfigurationImportFilter对应的配置，这里找到的是org.springframework.boot.autoconfigure.condition.OnClassCondition，检查规则如下

    经过上面的去重，排序，排除，(这里会有2个线程分别对前一半和后一半做检查)遍历所有剩下的class

    首先看是否有@ConditionalOnClass注解，如果没有那么不过滤，表示需要配置这个bean

    如果有@ConditionalOnClass注解再看这个注解依赖的类是否为空，如果为空，那么也不过滤，表示需要配置这个bean

    如果@ConditionalOnClass注解依赖的类不为空，那么再看classpath下能不能找到这个依赖的类，如果能找不到，那么也不过滤，表示需要配置这个bean，否则过滤，表示不配置这个bean
    
    该类的@ConditionalOnClass注解里有freemarker.template.Configuration.class和FreeMarkerConfigurationFactory.class类，如果classpath下能找到这2个类，那么就会自动加载FreeMarkerAutoConfiguration类
    
    最后去classpath下的JAR文件中包含的/META/spring.factories文件里查询org.springframework.boot.autoconfigure.AutoConfigurationImportListener对应的属性作为监听器，然后发布一个AutoConfigurationImportEvent事件
    
    最后交代一下，selectImports方法的调用时机，是在SpringBoot启动时，AbstractApplicationContext类refresh方法 -> invokeBeanFactoryPostProcessors方法 -> PostProcessorRegistrationDelegate类的invokeBeanFactoryPostProcessors方法 -> invokeBeanDefinitionRegistryPostProcessors方法 -> ConfigurationClassPostProcessor类的postProcessBeanDefinitionRegistry方法 -> processConfigBeanDefinitions方法 -> ConfigurationClassParser类的parse方法 -> processDeferredImportSelectors方法
    
    @ComponentScan注解会自动扫描指定包(如果不指定，那么默认扫描当前类路径以及子路径下的所有类)下的全部标有@Component(包括@Service、@Repository、@Controller等子注解)的类，并注册成bean
    
## SpringApplication的初始化

    