package app.braingasm.in.braingasm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;

import app.braingasm.in.braingasm.custom.BraingasmActivity;
import app.braingasm.in.braingasm.custom.Pegasus;
import app.braingasm.in.braingasm.models.QuestionPaper;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class QuestionPaperActivity extends BraingasmActivity {

    @Bind(R.id.fill_layout) LinearLayout fillLayout;
    @Bind(R.id.add) FloatingActionButton add;
    List<QuestionPaper> questionPapers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_paper);
        ButterKnife.bind(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionPaperActivity.this, UploadQuestionPaperActivity.class));
            }
        });
        makeJsonRequest();
    }

    private void makeJsonRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, getString(R.string.api_root_path) + "/question_papers", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.i("Json Request", response.toString());
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
                    questionPapers = Arrays.asList(objectMapper.readValue(response.toString(), QuestionPaper[].class));
                    for (QuestionPaper questionPaper: questionPapers) fillLayout.addView(questionPaper.getLayout(QuestionPaperActivity.this));
                } catch (Exception e) { e.printStackTrace(); }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Pegasus.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }
}
