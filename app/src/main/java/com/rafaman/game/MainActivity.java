package com.rafaman.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private WebView gameView;

    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        gameView = new WebView(this);
        gameView.setBackgroundColor(0xFF050505);
        WebSettings settings = gameView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(true);
        gameView.setWebChromeClient(new WebChromeClient());
        gameView.loadUrl("file:///android_asset/index.html");
        setContentView(gameView);
    }

    @Override protected void onResume() {
        super.onResume();
        if (gameView != null) gameView.onResume();
    }

    @Override protected void onPause() {
        if (gameView != null) gameView.onPause();
        super.onPause();
    }

    @Override protected void onDestroy() {
        if (gameView != null) gameView.destroy();
        super.onDestroy();
    }
}
