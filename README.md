## 加载Controller 

### MVC
dispatchServlet接受HTTP请求，适配合适的handler，handler通过反射得到Controller实例，得到返回的result，处理result并返回jsp或json到浏览器

### IoC
通过反射得到所有类，类中的所有方法，并检查其上的注解

### AOP
使用cglib实现动态代理，采用注解（声明式）实现AOP

### ControllerHelper类
通过ClassHelper,我们可以获取所有定义了Controller注解的类，通过反射获取该类所有带Action注解的方法，处理其中的请求表达式，进而获取请求方法与请求路径，封装一个请求对象（Request）与处理对象（Handler）,最后将Request,handler建立一个映射关系，放入一个Action Map 中，并提供一个可根据请求方法与请求路径获取处理对象的方法。
