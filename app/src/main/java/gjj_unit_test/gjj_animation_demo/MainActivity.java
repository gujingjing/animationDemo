package gjj_unit_test.gjj_animation_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_buzheng)
    Button btnBuzheng;
    @Bind(R.id.btn_bujian)
    Button btnBujian;
    @Bind(R.id.btn_shuxin)
    Button btnShuxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_buzheng,R.id.btn_bujian,R.id.btn_shuxin})void onclick(View view){
        switch (view.getId()){
            case R.id.btn_buzheng://帧动画
                startActivity(new Intent(MainActivity.this,ZhenActivity.class));
                break;
            case R.id.btn_bujian://补间动画
                startActivity(new Intent(MainActivity.this,BuJianActivity.class));
                break;
            case R.id.btn_shuxin://属性动画
                startActivity(new Intent(MainActivity.this,ShuXinActivity.class));
                break;
        }
    }
}
