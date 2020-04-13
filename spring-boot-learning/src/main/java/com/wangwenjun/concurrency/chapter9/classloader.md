ClassLoader:
- load class file into JVM
- class file are binary files, compiled by javac
- generate data structures of this class
- allocate memory for this class


class load process:
- load
- link: verify->prepare->parse
- initialize


initialize:
- JVM use lazy initialize
- a class initialized when it's first use
- first time positive use

**runtime package vs. package**

6 positive use scenario:
1. new class
2. access static variables read/write
3. access static method
4. reflect 
5. initialize sub class cause parent class initialize
6. start class. main method

others are not positive usage, cannot cause initialization of a class
1. construct a class array wont cause initialize
2. access static constant wont cause initialize
3. 



