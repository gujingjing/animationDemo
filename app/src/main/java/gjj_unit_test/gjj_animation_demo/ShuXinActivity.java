package gjj_unit_test.gjj_animation_demo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：gjj on 2016/3/29 11:04
 * 邮箱：Gujj512@163.com
 */
public class ShuXinActivity extends AppCompatActivity {
    @Bind(R.id.btn_test1)
    Button btnTest1;
    @Bind(R.id.btn_test2)
    Button btnTest2;
    @Bind(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuxin);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_test1, R.id.btn_test2})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_test1://ValueAnimator
                setBtnTest1();
                break;
            case R.id.btn_test2:
//                setAlp(tvTest);//设置透明
//                setRota(tvTest);//旋转
//                setTran(tvTest);//平移
//                setScal(tvTest);//缩放
//                setAll(tvTest);//组合
                xmlSetAnimation(tvTest);//xml设置动画
                break;
        }
    }

    public void setBtnTest1() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(3000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                Log.e("ShuXinActivity===", "value===" + value);
            }
        });
        anim.start();
    }

    public void setAlp(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }
    public void setRota(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }
    public void setTran(View view){
        float curTranslationX = view.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", curTranslationX, -500, curTranslationX);
        animator.setDuration(5000);
        animator.start();
    }
    public void setScal(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }
    public void setAll(View view){
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(view, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }
    public void xmlSetAnimation(View view){
        Animator animator = AnimatorInflater.loadAnimator(ShuXinActivity.this, R.animator.set_animation_demo);
        animator.setTarget(view);
        animator.start();
    }
}
