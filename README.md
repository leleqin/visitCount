"# visitCount" 

**案例说明**

一个项目中所有的资源被访问都要对访问量进行累加

**案例思路：**

1.当项目被第一次访问时，创建一个变量，设置其值为1，保存在ServletContext中
2.当以后访问的时候，就可以从ServletContext中获取这个变量，然后在其基础上加1

**代码思路**

1.获取ServletContext对象 
2.查看是否存在名为count的属性，如果存在，说明不是第一次访问；如果不存在，就说明是第一次访问。
3.第一次访问：调用ServletContext的setAttribute()方法传递一个属性，名为count，值为1
4.第2~n次访问：调用ServletContext的getAttribute()方法获取原来的访问量，给访问量+1，再调用ServletContext的setAttribute()方法存值。
