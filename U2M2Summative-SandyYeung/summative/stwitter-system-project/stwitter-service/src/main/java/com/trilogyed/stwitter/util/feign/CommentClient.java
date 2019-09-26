package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.domain.Comment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface CommentClient {
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    Comment createComment(@RequestBody Comment comment);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    Comment getComment(@PathVariable int id);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    void updateComment(@RequestBody Comment comment, @PathVariable int id);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    void deleteComment(@PathVariable int id);

    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    List<Comment> getAllCommentsByPostId(@PathVariable(name = "postId") int postId);
}
