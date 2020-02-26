算法(第4版)实例与练习
===

# 关于运行用例
项目使用Gradle管理,为配合<<算法>>中的用例执行,在IntelliJ IDEA(2019.3.3)
上设置了**Redirect input from**还是无效, 无奈只能采取如下方式. 虽然配置
有些麻烦,但是执行效率一样高,缺憾可能在于不便于调试.
```shell script
# config under Linux
$ ROOT=`pwd` 
$ cd $ROOT/algs4/build/classes/java/main
$ CLASSPATH=.:$ROOT/algs4/lib/algs4.jar:$CLASSPATH
$ java com.algs.basic.stack.Stack < tobe.txt 
```
上面针对于Linux下的配置进行说明:
1. 记录当前目录
1. 切换到.class生成目录下, 每次执行有修改的用例时需要先执行Build project或者Recompile
1. 设置classpath, 临时的classpath可通过java的-cp选项来配置
1. 执行用例, 可以将输入文件放到当前目录下,简化命令行代码
在Windows下类似的
```shell script
# config under windows
set ROOT=%CD%
cd %ROOT%\algs4\build\classes\java\main
set CLASSPATH=.;%ROOT%\algs4\lib\algs4.jar;%CLASSPATH%
java com.algs.basic.stack.Stack < tobe.txt 
```
已编写成脚本,执行即可加载对应配置:
```
# Linux执行
$ . usecase.sh
# windows执行
> usecase.bat
```