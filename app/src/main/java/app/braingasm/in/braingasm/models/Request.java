package app.braingasm.in.braingasm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    int id;
    Course course;
    String description;
    User requestedBy;
    String time;
    int bounty;
    enum Type { QUESTION_PAPER, NOTES }

}
