package app.braingasm.in.braingasm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Point {

    int id;
    boolean gain;
    int points;
    enum Type { CONTRIBUTION, KNOWLEDGE }
    enum Reason { UPVOTE, INFO }

}
