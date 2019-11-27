package com.jitenderkumar.demoducat.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jitenderkumar.demoducat.R;

public class AnimateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);

        ImageView imageView = findViewById(R.id.image_view);
        ImageView imageView2 = findViewById(R.id.image_view_2);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.sequential);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.slide_up);


        imageView.startAnimation(animation);
        imageView2.startAnimation(animation2);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
