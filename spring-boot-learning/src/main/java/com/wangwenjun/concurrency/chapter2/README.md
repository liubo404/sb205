1. 创建线程对象Thread.默认有一个张程名，以Thread-开立水大，从0开始

构造函数 Thread()
Thread-0
Thread-1
Thread-2
Thread-3

2. 如何在构造Thread的时候没有传递或者没有override
Thread的run方法，该thread 将不会调用任何东西。
如果传递了Runnable接口的实例，或者override了Thread的
run方法，则会执行该方法的逻辑单元/逻辑代码。



