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
import app.braingasm.in.braingasm.utils.NumberUtils;
import app.braingasm.in.braingasm.utils.WordUtils;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    enum Type { WORKSHOP, CONFERENCE, TECHTALK, HACKATHON, EXHIBIT, SYMPOSIUM, INTERN, JOB }

    int id;
    String title;
    String description;
    String uploadedTime;
    String date;
    String venue;
    Float fee;
    String eventLink;
    String imageLink;
    Type type;
    User host;
    int attendees;
    ArrayList<Topic> relatedTopics;
    ArrayList<Comment> comments;

    public void setType(String type) {
        switch (type) {
            case "workshop": this.type = Type.WORKSHOP; break;
            case "conference": this.type = Type.CONFERENCE; break;
            case "techtalk": this.type = Type.TECHTALK; break;
            case "hackathon": this.type = Type.HACKATHON; break;
            case "exhibit": this.type = Type.EXHIBIT; break;
            case "symposium": this.type = Type.SYMPOSIUM; break;
            case "intern": this.type = Type.INTERN; break;
            case "job": this.type = Type.JOB; break;
        }
    }

    public LinearLayout getLayout(Context context) {
        LinearLayout eventLayout = (LinearLayout) View.inflate(context, R.layout.repeatable_event_card, null);
        ImageLoader imageLoader = Pegasus.getInstance(context).getImageLoader();
        ((TextView) eventLayout.findViewById(R.id.title)).setText(title);
        ((TextView) eventLayout.findViewById(R.id.type)).setText(WordUtils.titleize(type.name()));
        ((TextView) eventLayout.findViewById(R.id.date)).setText(date);
        ((TextView) eventLayout.findViewById(R.id.venue)).setText(venue);
        ((TextView) eventLayout.findViewById(R.id.link)).setText(eventLink);
        ((TextView) eventLayout.findViewById(R.id.uploader)).setText(host.name);
        ((TextView) eventLayout.findViewById(R.id.uploaded_at)).setText(DateUtils.railsDateToLocalTime(uploadedTime));
        ((TextView) eventLayout.findViewById(R.id.description)).setText(description);
        if(fee.compareTo(0f)!=0) ((TextView) eventLayout.findViewById(R.id.fee)).setText(NumberUtils.getCurrencyFormatWithInr(fee));
        ((TextView) eventLayout.findViewById(R.id.attendee_count)).setText(String.valueOf(attendees));
        ((TextView) eventLayout.findViewById(R.id.comment_count)).setText(comments.size());
        ((NetworkImageView) eventLayout.findViewById(R.id.image)).setImageUrl(imageLink,imageLoader);
        eventLayout.findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        eventLayout.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        eventLayout.findViewById(R.id.comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return eventLayout;
    }

}
