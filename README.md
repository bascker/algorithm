# algorithm
## 一、简介
使用 Java 进行算法实现，项目基础结构
```
algorithm
|- base                 # 基础数据结构的实现
|- common               # 工具类等
|- practice             # 练习, 其中 @from 标识题目来源
|- sort                 # 排序算法
```

常见思路:  

1、逆序, 先进后出: 优先考虑栈
```
AddTwoNums
```          
2、结点操作: 考虑哨兵结点  
```        
RemoveLinkedListElements
```

## 二、运行
项目中使用的很多工具类依赖于 [bsutil](https://github.com/bascker/bsutil) 库。
```
<dependency>
    <groupId>com.baskcer.util</groupId>
    <artifactId>bsutil</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
项目中已添加该依赖，可`git clone https://github.com/bascker/bsutil.git`后，根据以下步骤引入 jar。
1. 执行 `mvn install`编译 bsutil-1.0-SNAPSHOT.jar 包。
2. 将 jar 包放到 mvn 配置的本地 repo 路径内
```
λ ls -al repo\mvn-repo\com\baskcer\util\bsutil\1.0-SNAPSHOT
total 22
drwxr-xr-x 1 bascker 197121     0 12月 29 19:53 ./
drwxr-xr-x 1 bascker 197121     0 12月 29 19:53 ../
-rw-r--r-- 1 bascker 197121 18879 12月 29 19:41 b
```

## 三、单元测试
代码修改后，本地 mvn 进行 test 测试, 测试套件会自动触发项目中的单元测试。
> 本项目使用 testng 作为单元测试套件

```
[INFO] --- maven-surefire-plugin:2.8.1:test (default-test) @ algorithm ---
[INFO] Surefire report directory: D:\..\code\algorithm\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.268 sec

Results :

Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
```