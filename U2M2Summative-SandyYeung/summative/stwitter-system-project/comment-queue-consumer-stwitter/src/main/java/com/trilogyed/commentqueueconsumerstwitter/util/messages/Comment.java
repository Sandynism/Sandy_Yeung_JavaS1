package com.trilogyed.commentqueueconsumerstwitter.util.messages;


import java.time.LocalDate;

public class Comment {
    private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public Comment(){}

    public Comment(int commentId, int postId, LocalDate createDate, String commenterName, String comment){
        this.commentId = commentId;
        this.postId = postId;
        this.createDate = createDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Comment ID='" + commentId + '\'' +
                ", Post ID='" + postId + '\'' +
                ", Create Date='" + createDate + '\'' +
                ", Commenter Name='" + commenterName + '\'' +
                ", Comment='" + comment + '\'' +
                '}';
    }
}
