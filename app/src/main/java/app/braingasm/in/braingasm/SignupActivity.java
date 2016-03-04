package app.braingasm.in.braingasm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.braingasm.in.braingasm.custom.BraingasmActivity;
import app.braingasm.in.braingasm.models.User;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class SignupActivity extends BraingasmActivity {

    @Bind(R.id.type) Spinner type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        List<User.Type> types = Arrays.asList(User.Type.values());
        List<String> typeString = new ArrayList<>();
        for(User.Type type: types) typeString.add(type.name());
        ArrayAdapter typeAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, typeString);
        typeAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        type.setAdapter(typeAdapter);
    }
}
