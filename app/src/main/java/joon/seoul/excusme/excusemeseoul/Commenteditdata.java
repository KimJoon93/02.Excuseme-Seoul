package joon.seoul.excusme.excusemeseoul;

public class Commenteditdata {
    String comment;
    String commentcontext;
    String commentwritername;
    String commentwriterid;

    public Commenteditdata(String comment, String commentcontext, String commentwritername, String commentwriterid) {
        this.comment = comment;
        this.commentcontext = commentcontext;
        this.commentwritername = commentwritername;
        this.commentwriterid = commentwriterid;
    }

    private Commenteditdata(){

    }

    public String getComment() {
        return comment;
    }

    public String getCommentcontext() {
        return commentcontext;
    }

    public String getCommentwritername() {
        return commentwritername;
    }

    public String getCommentwriterid() {
        return commentwriterid;
    }
}
