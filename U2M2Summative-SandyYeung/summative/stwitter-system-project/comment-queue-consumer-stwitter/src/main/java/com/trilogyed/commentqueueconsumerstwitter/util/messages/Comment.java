package com.trilogyed.commentqueueconsumerstwitter.util.messages;


import java.time.LocalDate;
import java.util.Objects;

public class Comment {
    private Integer commentId;
    private String commenterName;
    private String comment;

    public Comment(){}

    public Comment(Integer commentId, String commenterName, String comment){
        this.commentId = commentId;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(getCommentId(), comment1.getCommentId()) &&
                Objects.equals(getCommenterName(), comment1.getCommenterName()) &&
                Objects.equals(getComment(), comment1.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getCommenterName(), getComment());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Comment ID='" + commentId + '\'' +
                ", Commenter Name='" + commenterName + '\'' +
                ", Comment='" + comment + '\'' +
                '}';
    }
}
