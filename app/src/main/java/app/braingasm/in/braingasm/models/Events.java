package app.braingasm.in.braingasm.models;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class Events {

    int id;
    String title;
    enum Type { WORKSHOP, CONFERENCE, TECHTALK, HACKATHON, EXHIBIT, SYMPOSIUM, INTERN, JOB }
    String date;
    String venue;
    Float fee;
    String eventLink;
    ArrayList<Topic> relatedTopics;
    ArrayList<User> attendees;
    ArrayList<Comment> comments;

}
