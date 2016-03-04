package app.braingasm.in.braingasm.models;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
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
