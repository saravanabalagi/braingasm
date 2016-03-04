package app.braingasm.in.braingasm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zeke on Mar 04, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
    String url;

    public void setUrl(String url) {
        this.url = "http://braingasm.herokuapp.com"+url;
    }
}
