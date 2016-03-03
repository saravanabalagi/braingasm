package app.braingasm.in.braingasm.models;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class Notes {

    int id;
    Course course;
    String title;
    String description;
    Institution institution;
    int quality;
    int upvotes;
    User uploader;
    String uploadedTime;
    String coverLink;
    String pdfLink;
    ArrayList<Comment> comments;

}
