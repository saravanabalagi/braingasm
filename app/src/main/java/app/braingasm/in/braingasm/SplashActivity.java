package app.braingasm.in.braingasm;

import android.os.Bundle;
import android.support.annotation.Nullable;

import app.braingasm.in.braingasm.custom.BraingasmActivity;
import butterknife.ButterKnife;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class SplashActivity extends BraingasmActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }
}
