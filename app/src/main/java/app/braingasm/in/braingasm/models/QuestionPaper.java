package app.braingasm.in.braingasm.models;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import app.braingasm.in.braingasm.R;
import app.braingasm.in.braingasm.custom.Pegasus;
import app.braingasm.in.braingasm.utils.DateUtils;
import app.braingasm.in.braingasm.utils.WordUtils;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class QuestionPaper {

    enum Category { SEMESTER, ASSESSMENT, CLASS_TEST, MOCK_TEST, OTHERS }

    int id;
    Course course;
    College college;
    String month;
    String year;
    int quality;
    int likes;
    ArrayList<String> pages;
    String createdAt;
    User user;
    ArrayList<Comment> comments;
    Category category;

    public void setCategory(String category) {
        switch (category) {
            case "semester": this.category = Category.SEMESTER;
            case "assessment": this.category = Category.ASSESSMENT;
            case "class_test": this.category = Category.CLASS_TEST;
            case "mock_test": this.category = Category.CLASS_TEST;
            case "others": this.category = Category.CLASS_TEST;
        }
    }

    public LinearLayout getLayout(Context context) {
        LinearLayout questionPaperLayout = (LinearLayout) View.inflate(context, R.layout.repeatable_question_paper_card, null);
        ImageLoader imageLoader = Pegasus.getInstance(context).getImageLoader();
        ((TextView) questionPaperLayout.findViewById(R.id.course)).setText(course.title);
        ((TextView) questionPaperLayout.findViewById(R.id.type)).setText(WordUtils.titleize(category.name()));
        ((TextView) questionPaperLayout.findViewById(R.id.month)).setText(month);
        ((TextView) questionPaperLayout.findViewById(R.id.year)).setText(year);
        ((TextView) questionPaperLayout.findViewById(R.id.university)).setText(college.university.name);
        ((TextView) questionPaperLayout.findViewById(R.id.uploader)).setText(user.name);
        ((TextView) questionPaperLayout.findViewById(R.id.contribution_points)).setText(String.valueOf(user.contributionPoints));
        ((TextView) questionPaperLayout.findViewById(R.id.knowledge_points)).setText(String.valueOf(user.knowledgePoints));
        ((TextView) questionPaperLayout.findViewById(R.id.uploaded_at)).setText(DateUtils.railsDateToLocalTime(createdAt));
        ((TextView) questionPaperLayout.findViewById(R.id.quality)).setText(String.valueOf(quality));
        ((TextView) questionPaperLayout.findViewById(R.id.like_count)).setText(String.valueOf(likes));
        ((TextView) questionPaperLayout.findViewById(R.id.comment_count)).setText(comments.size());
        ((NetworkImageView) questionPaperLayout.findViewById(R.id.image)).setImageUrl(pages.get(0),imageLoader);
        if(user.avatar !=null) ((NetworkImageView) questionPaperLayout.findViewById(R.id.uploader_dp)).setImageUrl(user.avatar,imageLoader);
        questionPaperLayout.findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        questionPaperLayout.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        questionPaperLayout.findViewById(R.id.comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return questionPaperLayout;
    }

}
