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
    