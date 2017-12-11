# BadgeNumberManager中文文档

`BadgeNumberManager`支持国产主流手机品牌(华为、小米、OPPO、vivo)的桌面角标设置。


# Demo演示截图

![](https://github.com/beiliao-mobile/BadgeNumberManager/raw/master/Screenshots/demo.gif)


# 用法

为了支持华为手机的桌面角标设置，我们需要先在`AndroidManifest`里配置以下权限:

```
<uses-permission android:name="com.huawei.android.launcher.permission.CHANGE_BADGE"/>

```

然后，只需要调用以下方法就可以进行桌面角标的设置（小米手机除外，小米手机请参考demo里的处理方式）：

```
BadgeNumberManager.from(context).setBadgeNumber(num)

```

# 填坑记录(2017.12.11)

1. 经过测试，目前暂时不支持的机型：华为荣耀6、OPPO A59、OPPO R9，OPPO R11、vivo X9i（截止至2017.12.11）

2. 一开始以为某些机型不支持可能是少了某些跟角标设置相关的权限，于是反编译微信、QQ、支付宝，从这些App中收集`AndroidManifest`里配置的可能跟角标设置相关的权限，并添加到Demo中来测试，后来发现还是不行

3. 针对华为手机，在某些机型上，例如华为 mate9，在`manifest`里除了需要配置`com.huawei.android.launcher.permission.CHANGE_BADGE`权限之外，还需要配置`android.permission.INTERNET`权限才可以正常设置桌面角标（不过一般的App应该都会配置了`android.permission.INTERNET`权限）

4. 关于OPPO手机，在一些较旧的机型上可以正常设置桌面角标，但在一些比较新的机型上（例如OPPO R9，OPPO R11等），只有在通知权限管理中，有“在桌面图标上显示角标”这个选项的App才可以正常设置角标。目前就只发现QQ，微信，钉钉有这个权限，就连支付宝都没有这个权限。于是尝试着写了个Demo，将Demo的包名改成了微信的包名，然后在通知权限管理中，就出现了“在桌面图标上显示图标”这个选项。所以，在新的机型上，OPPO应该是根据包名来维护了一个白名单，只针对一些比较大型的IM类型的App开放桌面角标设置的权限。所以，这个问题暂时还没有解决方法



# 具体的实现探讨

关于桌面角标实现的探讨请查阅以下文章：

[简书专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](http://www.jianshu.com/p/199a9238015f)

[知乎专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](https://zhuanlan.zhihu.com/p/30581346?group_id=908378436218310656)

[掘金专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](https://juejin.im/post/59f2e59751882578c17ee275)

---

# BadgeNumberManager

An Android library supports badge notification like iOS in Huawei, Xiaomi, OPPO and vivo launchers.


# Demo Screenshot

![](https://github.com/beiliao-mobile/BadgeNumberManager/raw/master/Screenshots/demo.gif)


# Usage

This library supports badge notification like iOS in Huawei, Xiaomi, OPPO and vivo launchers.


In order to support `Huawei`(华为) launcher，we need to declare a permission in `AndroidManifest`:

```
<uses-permission android:name="com.huawei.android.launcher.permission.CHANGE_BADGE"/>

```

and then,just set the BadgeNumber like this:

```
BadgeNumberManager.from(context).setBadgeNumber(num)

```

# More detail

For more detail,please check these articles：

[简书专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](http://www.jianshu.com/p/199a9238015f)

[知乎专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](https://zhuanlan.zhihu.com/p/30581346?group_id=908378436218310656)

[掘金专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](https://juejin.im/post/59f2e59751882578c17ee275)







