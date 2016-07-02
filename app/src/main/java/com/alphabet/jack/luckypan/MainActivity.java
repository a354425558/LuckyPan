package com.alphabet.jack.luckypan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    LuckPanSurfaceView mLuckyPanView;
    ImageView mStartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//bridge configuration isn't available
        mLuckyPanView = (LuckPanSurfaceView)findViewById(R.id.id_luckypan);
        mStartBtn = (ImageView) findViewById(R.id.id_start_btn);
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mLuckyPanView.isStart()){
                    mStartBtn.setImageResource(R.drawable.stop);
                    mLuckyPanView.luckyStart(1);
                    Log.i("TAG","正在滚动中..." );
                }else {
                    Log.i("TAG","停止滚动..." );

                    //当前没有点击停止按钮
                    if (!mLuckyPanView.isShouldEnd()){
                        mStartBtn.setImageResource(R.drawable.start);
                        mLuckyPanView.luckyEnd();

                    }
                }
            }
        });
    }
}
