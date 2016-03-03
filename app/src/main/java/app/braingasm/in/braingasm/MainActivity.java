package app.braingasm.in.braingasm;

import android.os.Bundle;

import app.braingasm.in.braingasm.custom.BraingasmActivity;
import butterknife.ButterKnife;

public class MainActivity extends BraingasmActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
