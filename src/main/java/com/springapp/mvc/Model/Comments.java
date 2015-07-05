package com.springapp.mvc.Model;

import java.util.ArrayList;

/**
 * Created by Fleps_000 on 04.07.2015.
 */
public class Comments {

    private static ArrayList<Comment> comments;

    static {
        comments = new ArrayList<>();
        comments.add(new Comment("Stas", "Davidov", "deviceID_1", "Like it so much. I don't know what, but i do."));
        comments.add(new Comment("Ilya", "Fedorov", "deviceID_2", "Dislike."));
        comments.add(new Comment("Vitya", "Komarov", "deviceID_3", "Parapa-pa-pa. I'm loving it!."));
    }
    public static void addComment(Comment comment) {
        comments.add(0, comment);
    }

    public static ArrayList<Comment> getAll() {
        return comments;
    }

    public static int getSize() {
        return comments.size();
    }

    public static ArrayList<Comment> getMyComments(String DeviceID) {
        ArrayList<Comment> myComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getDeviceID().equals(DeviceID)) myComments.add(comment);
        }
        return myComments;
    }
}
