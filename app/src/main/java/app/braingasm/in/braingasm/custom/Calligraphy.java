package app.braingasm.in.braingasm.custom;

import android.app.Application;

import app.braingasm.in.braingasm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Zeke on Mar 03, 2016.
 */

public class Calligraphy extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/myriadpro.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
