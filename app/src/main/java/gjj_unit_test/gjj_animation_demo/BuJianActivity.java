package gjj_unit_test.gjj_animation_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：gjj on 2016/3/29 11:04
 * 邮箱：Gujj512@163.com
 */
public class BuJianActivity extends AppCompatActivity {
    @Bind(R.id.btn_alph)
    Button btnAlph;
    @Bind(R.id.btn_tran)
    Button btnTran;
    @Bind(R.id.btn_scale)
    Button btnScale;
    @Bind(R.id.btn_rota)
    Button btnRota;
    @Bind(R.id.btn_set)
    Button btnSet;
    @Bind(R.id.iv_show)
    ImageView ivShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bujan);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_alph,R.id.btn_tran,R.id.btn_scale,R.id.btn_rota,R.id.btn_set})void onclick(View view){
        switch (view.getId()){
            case R.id.btn_alph://透明
                alphaImpl(ivShow);
                break;
            case R.id.btn_tran://位移
                translateImpl(ivShow);
                break;
            case R.id.btn_scale://缩放
                scaleImpl(ivShow);
                break;
            case R.id.btn_rota://旋转
                rotateImpl(ivShow);
                break;
            case R.id.btn_set://组合
                setAll(ivShow);
                break;

        }
    }
    // 透明动画
    public void alphaImpl(View view) {

        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.alpha_demo);
        view.startAnimation(animation);
    }

    // 旋转动画
    public void rotateImpl(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.rotate_demo);
        view.startAnimation(animation);
    }

    // 缩放动画
    public void scaleImpl(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.scale_demo);
        view.startAnimation(animation);
    }

    // 移动效果
    public void translateImpl(View view) {
        // XML文件
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.translate_demo);

        animation.setRepeatCount(Animation.INFINITE);//循环显示
        view.startAnimation(animation);

        /*
         * 第一种 imageView.setAnimation(animation); animation.start();
         */
        // 第二种

        // Java代码
        /*
         * TranslateAnimation translateAnimation = new TranslateAnimation(0,
         * 200, 0, 0); translateAnimation.setDuration(2000);
         * imageView.startAnimation(translateAnimation);
         */
    }

    // 综合实现set_demo.xml中的动画
    public void setAll(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.set_demo);
        view.startAnimation(animation);
    }
}
