package com.ibeiliao.badge;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ibeiliao.badgenumberlibrary.BadgeNumberManager;
import com.ibeiliao.badgenumberlibrary.BadgeNumberManagerXiaoMi;
import com.ibeiliao.badgenumberlibrary.MobileBrand;

public class MainActivity extends AppCompatActivity {

    private TextView ivMobileBrand;
    private Button btnSetBadge;
    private Button btnClear;
    private int mCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMobileBrand = (TextView) findViewById(R.id.iv_mobile_brand);
        btnSetBadge = (Button) findViewById(R.id.btn_set_badge);
        btnClear = (Button) findViewById(R.id.btn_clear);
        ivMobileBrand.setText("手机品牌：" + Build.MANUFACTURER);
        btnSetBadge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置应用在桌面上显示的角标
                if (!Build.MANUFACTURER.equalsIgnoreCase(MobileBrand.XIAOMI)) {
                    BadgeNumberManager.from(MainActivity.this).setBadgeNumber(10);
                    Toast.makeText(MainActivity.this, "设置桌面角标成功", Toast.LENGTH_SHORT).show();
                } else {
                    btnSetBadge.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setXiaomiBadgeNumber();
                        }
                    },3000);
                    //小米手机如果在应用内直接调用设置角标的方法，设置角标会不生效,因为在退出应用的时候角标会自动消除
                    //这里先退出应用，延迟3秒后再进行角标的设置，模拟在后台收到推送并更新角标的情景
                    moveTaskToBack(true);
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置应用在桌面上显示的角标,小米机型只要用户点击了应用图标进入应用，会自动清除掉角标
                if (!Build.MANUFACTURER.equalsIgnoreCase(MobileBrand.XIAOMI)) {
                    BadgeNumberManager.from(MainActivity.this).setBadgeNumber(0);
                    Toast.makeText(MainActivity.this, "清除桌面角标成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setXiaomiBadgeNumber() {
        NotificationManager notificationManager = (NotificationManager) MainActivity.this.
                getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(MainActivity.this.getApplicationInfo().icon)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("推送标题")
                .setContentText("我是推送内容")
                .setTicker("ticker")
                .setAutoCancel(true)
                .build();
        //相邻的两次角标设置如果数字相同的话，好像下一次会不生效
        BadgeNumberManagerXiaoMi.setBadgeNumber(notification,mCount++);
        notificationManager.notify(1000, notification);
        Toast.makeText(MainActivity.this, "设置桌面角标成功", Toast.LENGTH_SHORT).show();

    }
}
