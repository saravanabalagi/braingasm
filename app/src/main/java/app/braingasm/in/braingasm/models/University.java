package app.braingasm.in.braingasm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class University {

    int id;
    String name;

}
