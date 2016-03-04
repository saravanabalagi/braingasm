package app.braingasm.in.braingasm.models;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

import app.braingasm.in.braingasm.R;
import app.braingasm.in.braingasm.custom.Pegasus;
import app.braingasm.in.braingasm.utils.DateUtils;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notes {

    int id;
    Course course;
    String title;
    String description;
    College college;
    int quality;
    int likes;
    User uploader;
    String uploadedTime;
    String coverLink;
    String pdfLink;
    ArrayList<Comment> comments;

    public LinearLayout getLayout(Context context) {
        LinearLayout notesLayout = (LinearLayout) View.inflate(context, R.layout.repeatable_notes_card, null);
        ImageLoader imageLoader = Pegasus.getInstance(context).getImageLoader();
        ((TextView) notesLayout.findViewById(R.id.title)).setText(title);
        ((TextView) notesLayout.findViewById(R.id.course)).setText(course.title);
        ((TextView) notesLayout.findViewById(R.id.university)).setText(college.university);
        ((TextView) notesLayout.findViewById(R.id.uploader)).setText(uploader.name);
        ((TextView) notesLayout.findViewById(R.id.contribution_points)).setText(uploader.contributionPoints);
        ((TextView) notesLayout.findViewById(R.id.knowledge_points)).setText(uploader.knowledgePoints);
        ((TextView) notesLayout.findViewById(R.id.uploaded_at)).setText(DateUtils.railsDateToLocalTime(uploadedTime));
        ((TextView) notesLayout.findViewById(R.id.quality)).setText(quality);
        ((TextView) notesLayout.findViewById(R.id.like_count)).setText(likes);
        ((TextView) notesLayout.findViewById(R.id.comment_count)).setText(comments.size());
        ((NetworkImageView) notesLayout.findViewById(R.id.image)).setImageUrl(coverLink,imageLoader);
        if(uploader.avatar !=null) ((NetworkImageView) notesLayout.findViewById(R.id.uploader_dp)).setImageUrl(uploader.avatar.url,imageLoader);
        notesLayout.findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        notesLayout.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        notesLayout.findViewById(R.id.comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return notesLayout;
    }

}
