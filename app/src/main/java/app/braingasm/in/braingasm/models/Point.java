package app.braingasm.in.braingasm.models;

/**
 * Created by Zeke on Mar 03, 2016.
 */
public class Point {

    int id;
    boolean gain;
    int points;
    enum Type { CONTRIBUTION, KNOWLEDGE }
    enum Reason { UPVOTE, INFO }

}
