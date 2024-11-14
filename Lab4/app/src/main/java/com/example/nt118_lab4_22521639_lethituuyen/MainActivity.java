package com.example.nt118_lab4_22521639_lethituuyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_uit_logo;
    //xml
    private Button btn_fade_in_xml, btn_fade_out_xml, btn_blink_xml, btn_zoom_in_xml, btn_zoom_out_xml;
    private Button btn_rotate_xml, btn_move_xml, btn_slide_up_xml, btn_bounce_xml, btn_combine_xml;
    //code
    private Button btn_fade_in_code, btn_fade_out_code, btn_blink_code, btn_zoom_in_code, btn_zoom_out_code;
    private Button btn_rotate_code, btn_move_code, btn_slide_up_code, btn_bounce_code, btn_combine_code;

    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        // Gọi hàm để xử lý các nút xml
        handleClickAnimationXml(btn_fade_in_xml, R.anim.anim_fade_in);
        handleClickAnimationXml(btn_fade_out_xml, R.anim.anim_fade_out);
        handleClickAnimationXml(btn_blink_xml, R.anim.anim_blink);
        handleClickAnimationXml(btn_zoom_in_xml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btn_zoom_out_xml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btn_rotate_xml, R.anim.anim_rotate);
        handleClickAnimationXml(btn_move_xml, R.anim.anim_move);
        handleClickAnimationXml(btn_slide_up_xml, R.anim.anim_slide_up);
        handleClickAnimationXml(btn_bounce_xml, R.anim.anim_bounce);
        handleClickAnimationXml(btn_combine_xml, R.anim.anim_combine);

        // Gọi hàm để xử lý các nút code
        handleClickAnimationCode(btn_fade_in_code, initFadeInAnimation());
        handleClickAnimationCode(btn_fade_out_code, initFadeOutAnimation());
        handleClickAnimationCode(btn_blink_code, initBlinkAnimation());
        handleClickAnimationCode(btn_zoom_in_code, initZoomInAnimation());
        handleClickAnimationCode(btn_zoom_out_code, initZoomOutAnimation());
        handleClickAnimationCode(btn_rotate_code, initRotateAnimation());
        handleClickAnimationCode(btn_move_code, initMoveAnimation());
        handleClickAnimationCode(btn_slide_up_code, initSlideUpAnimation());
        handleClickAnimationCode(btn_bounce_code, initBounceAnimation());
        handleClickAnimationCode(btn_combine_code, initCombineAnimation());

        iv_uit_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right); // Chuyển từ phải sang trái
            }
        });



    }

    private void findViewsByIds() {
        iv_uit_logo = findViewById(R.id.iv_uit_logo);

        //xml
        btn_fade_in_xml = findViewById(R.id.btn_fade_in_xml);
        btn_fade_out_xml = findViewById(R.id.btn_fade_out_xml);
        btn_blink_xml = findViewById(R.id.btn_blink_xml);
        btn_zoom_in_xml = findViewById(R.id.btn_zoom_in_xml);
        btn_zoom_out_xml = findViewById(R.id.btn_zoom_out_xml);
        btn_rotate_xml = findViewById(R.id.btn_rotate_xml);
        btn_move_xml = findViewById(R.id.btn_move_xml);
        btn_slide_up_xml = findViewById(R.id.btn_slide_up_xml);
        btn_bounce_xml = findViewById(R.id.btn_bounce_xml);
        btn_combine_xml = findViewById(R.id.btn_combine_xml);
        //code
        btn_fade_in_code = findViewById(R.id.btn_fade_in_code);
        btn_fade_out_code = findViewById(R.id.btn_fade_out_code);
        btn_blink_code = findViewById(R.id.btn_blink_code);
        btn_zoom_in_code = findViewById(R.id.btn_zoom_in_code);
        btn_zoom_out_code = findViewById(R.id.btn_zoom_out_code);
        btn_rotate_code = findViewById(R.id.btn_rotate_code);
        btn_move_code = findViewById(R.id.btn_move_code);
        btn_slide_up_code = findViewById(R.id.btn_slide_up_code);
        btn_bounce_code = findViewById(R.id.btn_bounce_code);
        btn_combine_code = findViewById(R.id.btn_combine_code);

    }

    private void initVariables() {
        // Khởi tạo animationListener và override các phương thức của nó
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Xử lý khi hoạt ảnh bắt đầu (Có thể để trống hoặc thêm hành động nếu cần)
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Khi hoạt ảnh kết thúc, hiển thị một thông báo Toast
                Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Xử lý khi hoạt ảnh lặp lại (Có thể để trống hoặc thêm hành động nếu cần)
            }
        };
    }

    // Hàm xử lý khi nhấn nút, khởi tạo và áp dụng hoạt ảnh từ XML
    private void handleClickAnimationXml(Button btn, int animId) {
        final Animation animation = AnimationUtils.loadAnimation(this, animId);
        animation.setAnimationListener(animationListener);  // Gắn listener cho animation

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_uit_logo.startAnimation(animation);  // Áp dụng hoạt ảnh cho iv_uit_logo
            }
        });
    }
    // Hàm xử lý khi nhấn nút, khởi tạo và áp dụng hoạt ảnh từ code
    private void handleClickAnimationCode(Button btn, Animation animation) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_uit_logo.startAnimation(animation);
            }
        });
    }
    private Animation initFadeInAnimation(){
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0f, 1.0f);
        alphaanimation.setDuration(1000);
        alphaanimation.setFillAfter(true);
        return alphaanimation;
    }
    private Animation initFadeOutAnimation() {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0f, 0.0f);
        alphaanimation.setDuration(1000);
        alphaanimation.setFillAfter(true);
        return alphaanimation;
    }
    private Animation initBlinkAnimation() {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0f, 1.0f);
        alphaanimation.setDuration(1000);
        alphaanimation.setRepeatCount(3);
        alphaanimation.setRepeatMode(Animation.REVERSE);
        alphaanimation.setFillAfter(true);
        return alphaanimation;
    }
    private Animation initRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f  // pivotY
        );
        rotateAnimation.setDuration(600); // Thời gian
        rotateAnimation.setRepeatMode(Animation.RESTART); // Chế độ lặp lại
        rotateAnimation.setRepeatCount(2); // Số lần lặp lại
        rotateAnimation.setFillAfter(true);
        return rotateAnimation;
    }

    private Animation initZoomInAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 3f,
                1f, 3f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }
    private Animation initZoomOutAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 0.25f,
                1f, 0.25f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        return scaleAnimation;
    }

    private Animation initMoveAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0.75f,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0
        );
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(getApplicationContext(), android.R.anim.linear_interpolator)); // Thiết lập interpolator
        return translateAnimation;
    }
    private Animation initSlideUpAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 1f,
                1.0f, 0.0f
        );
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }
    private Animation initBounceAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 1f,
                0.0f, 1.0f
        );
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        return scaleAnimation;
    }
    private Animation initCombineAnimation() {
        AnimationSet animationSet = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 3f,
                1f, 3f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(4000);
        scaleAnimation.setFillAfter(true);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setRepeatMode(Animation.RESTART);

        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;
    }

}
