package app.braingasm.in.braingasm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public enum Type { STUDENT, ENTREPRENEUR }

    int id;
    String name;
    String email;
    String password;
    College college;
    Avatar avatar;
    String degree;
    String branch;
    String sememster;
    String city;
    String state;
    String country;
    ArrayList<Topic> interestedTopics;
    Type type;

    int contributionPoints;
    int knowledgePoints;

    public void setType(String type) {
        switch (type) {
            case "student": this.type = Type.STUDENT; break;
            case "entrepreneur": this.type = Type.ENTREPRENEUR; break;
            default: this.type = Type.STUDENT;
        }
    }

}
