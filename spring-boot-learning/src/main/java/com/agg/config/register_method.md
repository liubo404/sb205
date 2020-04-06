# 给ioc中注册bean的方式
## 1.包扫描+注册(@Controller/@Service/@Repository/@Component) [自己写的类]

## 2.@Bean[导入的第三方包里的组件]

## 3.@Import[快速给ioc中导入一个组件]

- 3.1.@Import(要导入的组件的类),容器不会自动注册这个类,id默认是全类名 
- 3.2.ImportSelector:返回需要导入的组件的全类名
- 3.3.ImportBeanDefinitionRegistrar: 手动注册bean到ioc中

## 4.使用spring提供的FactoryBean
- 1.默认获取到的是工厂Bean调用getObject方法创建的对象
- 2.要获取工厂Bean本身，需要给id前面加一个&,如：&colorFactoryBean


# Bean的生命周期
- 从创建。初始化。销毁的过程

## 构造(创建对象)
- singleton: 在ioc启动时创建对象
- multiple:  在每次获取时创建对象

## 初始化:对象创建完成，属性也已赋好值，此时调用初始化方法...

## 销毁: 
- singleton: ioc关闭时调用
- multiple: 容器不会管理这个bean; 容器不会调用销毁方法;（可以手工调销毁方法）

## 注
- IOC管理bean的生命周期:
我们可以自定义初始化和销毁方法，IOC在bean进行到当前生命周期的时候会来调用我们自定义的初始化
和销毁方法。

## 管理生命周期的方式
- 1.通过@Bean注解指定初始化init-method和销毁方法destroy-method
- 2.实现接口。
   通过让Bean实现InitializeBean(定义寝始化逻辑)
   通过让Bean实现DisposableBean(定义销毁逻辑) 
- 3.使用JSR250
   - @PostConstruct: 在bean创建完成并且属性赋值完成，来执行初始化
   - @PreDestroy:在容器销毁bean之前，进行清理工作
- 4.BeanPostProcessor Bean的后置处理器
  在Bean初始化前后进行一些处理工作   
  postProcessBeforeInitialization:在初始化之前工作
  postProcessAfterInitialization:在初始化之后工作
  
  
  
    