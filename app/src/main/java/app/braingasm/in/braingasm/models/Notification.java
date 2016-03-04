package app.braingasm.in.braingasm.models;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.braingasm.in.braingasm.R;
import app.braingasm.in.braingasm.utils.WordUtils;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

    enum Type { LIKE, NEW, COMMENT }
    public enum ObjectType { QUESTION_PAPER, NOTES, EVENT }

    int id;
    User user;
    Object notificationObject;
    Type type;
    ObjectType objectType;
    String notificationText;

    public void setObjectType(String objectType) {
        switch (objectType) {
            case "question_paper": this.objectType = ObjectType.QUESTION_PAPER; break;
            case "notes": this.objectType = ObjectType.NOTES; break;
            case "event": this.objectType = ObjectType.EVENT; break;
        }
    }

    public void setType(String type) {
        switch (type) {
            case "like": this.type = Type.LIKE; break;
            case "new": this.type = Type.NEW; break;
            case "comment": this.type = Type.COMMENT; break;
        }
    }

    public void setNotificationObject(String notificationObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            switch (objectType) {
                case QUESTION_PAPER: this.notificationObject = objectMapper.readValue(notificationObject, QuestionPaper.class); break;
                case NOTES: this.notificationObject = objectMapper.readValue(notificationObject, Notes.class); break;
                case EVENT: this.notificationObject = objectMapper.readValue(notificationObject, Event.class); break;
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public LinearLayout getLayout(Context context) {
        LinearLayout notificationLayout = (LinearLayout) View.inflate(context, R.layout.repeatable_notification_card, null);
        String objectDef = "";
        switch (objectType) {
            case QUESTION_PAPER: objectDef = (((QuestionPaper) notificationObject).name + ((QuestionPaper) notificationObject).college.university); break;
            case NOTES: objectDef = ((Notes) notificationObject).title; break;
            case EVENT: objectDef = ((Event) notificationObject).title; break;
        }
        switch (type) {
            case LIKE:
                ((ImageView) notificationLayout.findViewById(R.id.icon)).setImageResource(R.drawable.svg_android_like);
                notificationText = user.name
                        + ((objectType == ObjectType.EVENT)?" is attending your ":" has liked your ")
                        + WordUtils.titleize(objectType.name()).toLowerCase()
                        + objectDef;
                break;
            case COMMENT:
                ((ImageView) notificationLayout.findViewById(R.id.icon)).setImageResource(R.drawable.svg_android_comment);
                notificationText = user.name
                        + " has commented on your "
                        + WordUtils.titleize(objectType.name()).toLowerCase()
                        + objectDef;
                break;
            case NEW:
                switch (objectType) {
                    case QUESTION_PAPER: ((ImageView) notificationLayout.findViewById(R.id.icon)).setImageResource(R.drawable.svg_android_question_paper);  break;
                    case NOTES: ((ImageView) notificationLayout.findViewById(R.id.icon)).setImageResource(R.drawable.svg_android_notes);  break;
                    case EVENT: ((ImageView) notificationLayout.findViewById(R.id.icon)).setImageResource(R.drawable.svg_android_event);  break;
                }
                notificationText = user.name
                        + ((objectType == ObjectType.EVENT)?" has uploaded a new ":" has created a new ")
                        + WordUtils.titleize(objectType.name()).toLowerCase()
                        + objectDef;
                break;
        }
        ((TextView) notificationLayout.findViewById(R.id.comment)).setText(notificationText);
        return notificationLayout;
    }

}
