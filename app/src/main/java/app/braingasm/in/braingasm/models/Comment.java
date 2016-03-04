package app.braingasm.in.braingasm.models;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import app.braingasm.in.braingasm.R;
import app.braingasm.in.braingasm.custom.Pegasus;

/**
 * Created by Zeke on Mar 03, 2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    int id;
    String content;
    User commenter;
    String createdAt;
    int likes;
    int pageNumber;

    public LinearLayout getLayout(Context context) {
        LinearLayout commentLayout = (LinearLayout) View.inflate(context, R.layout.repeatable_comment_card, null);
        ImageLoader imageLoader = Pegasus.getInstance(context).getImageLoader();
        ((NetworkImageView) commentLayout.findViewById(R.id.dp)).setImageUrl(commenter.avatar.url,imageLoader);
        ((TextView) commentLayout.findViewById(R.id.uploader)).setText(commenter.name);
        ((TextView) commentLayout.findViewById(R.id.contribution_points)).setText(commenter.contributionPoints);
        ((TextView) commentLayout.findViewById(R.id.knowledge_points)).setText(commenter.knowledgePoints);
        ((TextView) commentLayout.findViewById(R.id.comment)).setText(content);
        return commentLayout;
    }

}
