package app.braingasm.in.braingasm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;

import java.io.IOException;

import app.braingasm.in.braingasm.custom.BraingasmActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class CameraCaptureActivity extends BraingasmActivity {

    @Bind(R.id.image) ImageView image;
    @Bind(R.id.image_layout) FrameLayout imageLayout;
    @Bind(R.id.done) FloatingActionButton done;

    int REQUEST_CODE = 99;
    int preference = ScanConstants.OPEN_CAMERA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_capture);
        ButterKnife.bind(this);

        Intent intent = new Intent(this, ScanActivity.class);
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, preference);
        startActivityForResult(intent, REQUEST_CODE);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getExtras().getParcelable(ScanConstants.SCANNED_RESULT);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                getContentResolver().delete(uri, null, null);
                image.setImageBitmap(bitmap);
                done.setVisibility(View.VISIBLE);
                imageLayout.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
