package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.Post;
import com.trilogyed.stwitter.domain.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    PostClient postClient;
    CommentClient commentClient;

    public ServiceLayer(PostClient postClient, CommentClient commentClient) {
        this.postClient = postClient;
        this.commentClient = commentClient;
    }



    private PostViewModel buildPost(Post post, Comment comment) {
        List<Comment> commentsList = commentClient.getAllCommentsByPostId(postClient.getPost(post.getPostId()).getPostId());
        List<String> stringComments = new ArrayList<>();
        for (Comment c : commentsList) {
            stringComments.add(c.getComment());
        }

        //post here is a view model
        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(postClient.getPost(post.getPostId()).getPostId());
        pvm.setPost(postClient.getPost(post.getPostId()).getPost());
        pvm.setPostDate(postClient.getPost(post.getPostId()).getPostDate());
        pvm.setPosterName(postClient.getPost(post.getPostId()).getPosterName());
        pvm.setComments(stringComments);

        return pvm;
    }
}
