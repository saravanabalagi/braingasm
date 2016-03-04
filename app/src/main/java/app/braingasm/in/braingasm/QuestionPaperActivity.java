package app.braingasm.in.braingasm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import app.braingasm.in.braingasm.custom.BraingasmActivity;
import app.braingasm.in.braingasm.models.QuestionPaper;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class QuestionPaperActivity extends BraingasmActivity {

    @Bind(R.id.fill_layout) LinearLayout fillLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_paper);
        ButterKnife.bind(this);

        QuestionPaper questionPaper = new QuestionPaper();
        fillLayout.addView(questionPaper.getLayout(this));

    }
}
