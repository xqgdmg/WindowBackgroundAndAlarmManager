package ugou.ugou88.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);// 如果不设置回来，哪个图片和背景一直不会消失，也不会使用APP的主题，使用的是 AndroidManifest 中 <activity></activity>中配置的theme.
        setContentView(R.layout.activity_main);

        // AlarmManager 的简单使用
        intent = new Intent(MainActivity.this,HorizonService.class);
        startService(intent);

    }

    /**
     * AlarmManager 的简单使用
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }
}
