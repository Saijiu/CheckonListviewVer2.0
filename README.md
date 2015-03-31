# CheckonListviewVer2.0

粗略看了下Service和Broadcast Receiver，必须要写点东西才能告诉别人我看过了！<br>
但是这两个东西都不太好表示，不如看得见摸得着的Activity来的直接。<br>
想了想还是继续改进之前写的那个[带选中效果的ListView](https://github.com/moiling/CheckOnListViewDemo)。<br>
在这里有两个项目，其中**ShowStateApplication**就是之前ListView的扩展，而**Chooseitem**则是新加的一个扩展功能。<br>

我们先看一下是个什么效果吧（模拟器有些卡……）：<br>

![image](https://github.com/moiling/CheckonListviewVer2.0/blob/master/art/1.gif?raw=true)<br>

![image](https://github.com/moiling/CheckonListviewVer2.0/blob/master/art/2.gif?raw=true)<br>

一点都看不懂？唉……我也没办法了，能看懂的，我就提供一下思路吧！<br>
如果看过Service和Broadcast Receiver的话，很容易就懂了！<br>
![image](https://github.com/moiling/CheckonListviewVer2.0/blob/master/art/3.png?raw=true)<br>

还存在的问题：<br>
- 1.关闭app后，还会继续在后台运行……
- 2.输入item的地方，若为空时提交会报错……判断了!(getText().toString()).equals("")无效
- **已改正！！**因为之前在为空判断前转成int了！是int报错，我没看仔细
- 3.太丑
- 4.单例没做好
