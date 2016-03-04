package app.braingasm.in.braingasm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    int id;
    String code;
    String title;
    College college;
    String branch;
    String degree;
    String regulation;
    String semester;
    ArrayList<Topic> relatedTopics;

}
