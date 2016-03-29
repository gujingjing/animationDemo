package gjj_unit_test.gjj_animation_demo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：gjj on 2016/3/29 11:04
 * 邮箱：Gujj512@163.com
 */
public class ZhenActivity extends AppCompatActivity {
    @Bind(R.id.btn_start)
    Button btnStart;
    @Bind(R.id.btn_end)
    Button btnEnd;
    @Bind(R.id.iv_animation)
    ImageView ivAnimation;

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zheng);
        ButterKnife.bind(this);
        animationDrawable = (AnimationDrawable) ivAnimation.getBackground();
//        animationDrawable.start();//开始
        // animationDrawable.setOneShot(false);是否循环播放
        // animationDrawable.stop();停止播放
        // animationDrawable.isRunning();//是否播放
        // animationDrawable.getNumberOfFrames();//播放帧
        // animationDrawable.getFrame(index); 返回制定索引的 Drawable对象
        // animationDrawable.getDuration(i);停留的时间
    }
    @OnClick({R.id.btn_start,R.id.btn_end})void onclick(View view){
        switch (view.getId()){
            case R.id.btn_start:
                animationDrawable.start();//开始
                break;
            case R.id.btn_end:
                animationDrawable.stop();//停止播放
                break;
        }
    }
}
