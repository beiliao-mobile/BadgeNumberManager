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

[知乎专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](https://zhuanlan.zhihu.com/p/30581346?group_id=908378436218310656)

[掘金专栏：有关Android应用桌面角标(BadgeNumber)实现的探讨](https://juejin.im/post/59f2e59751882578c17ee275)




