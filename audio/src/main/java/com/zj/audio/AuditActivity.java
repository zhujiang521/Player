package com.zj.audio;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zj.audio.live.LivePusher;
import com.zj.audio.live.ScreenUtilsKt;


public class AuditActivity extends AppCompatActivity {

    private LivePusher livePusher;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit);
        SurfaceView surfaceView = findViewById(R.id.surfaceView);
        url = getIntent().getStringExtra("liveUrl");
        int width = getIntent().getIntExtra("width", ScreenUtilsKt.getAppScreenWidth(this));
        int height = getIntent().getIntExtra("height", ScreenUtilsKt.getAppScreenHeight(this));
        int bitrate = getIntent().getIntExtra("bitrate", 800_000);
        int fps = getIntent().getIntExtra("fps", 26);
        livePusher = new LivePusher(this, width, height, bitrate, fps, Camera.CameraInfo.CAMERA_FACING_BACK);
        //  设置摄像头预览的界面
        livePusher.setPreviewDisplay(surfaceView.getHolder());
    }

    public void switchCamera(View view) {
        livePusher.switchCamera();
    }

    public void startLive(View view) {
        livePusher.startLive(url);
    }

    public void stopLive(View view) {
        livePusher.stopLive();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        livePusher.release();
    }
}
