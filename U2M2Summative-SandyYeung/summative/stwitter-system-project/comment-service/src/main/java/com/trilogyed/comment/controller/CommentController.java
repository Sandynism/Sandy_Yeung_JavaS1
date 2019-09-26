package com.trilogyed.comment.controller;

import com.trilogyed.comment.model.Comment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class CommentController {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment) {
        return null;
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment, @PathVariable int id) {

    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public void deleteComment(@PathVariable int id) {

    }

    @RequestMapping(value="/comments/post/{postId}", method = RequestMethod.GET)
    public List<Comment> getAllCommentsByPostId(@PathVariable(name="postId") int postId) {
        return null;
    }
}

