package app.braingasm.in.braingasm.models;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class Request {

    int id;
    Course course;
    String description;
    User requestedBy;
    String time;
    int bounty;
    enum Type { QUESTION_PAPER, NOTES }

}
