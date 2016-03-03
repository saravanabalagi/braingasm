package app.braingasm.in.braingasm.models;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class User {

    int id;
    String name;
    String email;
    String password;
    Institution institution;
    String degree;
    String branch;
    String sememster;
    String city;
    String state;
    String country;
    ArrayList<Topic> interestedTopics;

    int contributionPoints;
    int knowledgePoints;

}
