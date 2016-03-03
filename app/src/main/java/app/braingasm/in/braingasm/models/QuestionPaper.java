package app.braingasm.in.braingasm.models;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class QuestionPaper {

    int id;
    Course course;
    Institution institution;
    String publishedMonth;
    String publishedYear;
    int quality;
    int upvotes;
    User user;
    String coverLink;
    String pdfLink;
    enum Category { SEMESTER, ASSESSMENT, CLASS_TEST }
    String uploadedTime;
    User uploader;
    ArrayList<Comment> comments;

}
