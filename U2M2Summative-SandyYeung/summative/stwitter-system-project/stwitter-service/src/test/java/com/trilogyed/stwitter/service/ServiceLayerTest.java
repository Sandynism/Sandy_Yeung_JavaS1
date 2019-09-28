package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.Post;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    PostClient pc;
    CommentClient cc;


    @Before
    public void setUp() throws Exception {
        setUpPostClientMocks();
        setUpCommentClientMocks();
        serviceLayer= new ServiceLayer(pc, cc);
    }

    private void setUpPostClientMocks(){
        pc = mock(PostClient.class);

        Post post = new Post();
        post.setPostId(1);
        post.setPost("First tweet.");
        post.setPostDate(LocalDate.of(2019, 9, 26));
        post.setPosterName("Sandy");

        Post post1 = new Post();
        post1.setPost("First tweet.");
        post1.setPostDate(LocalDate.of(2019, 9, 26));
        post1.setPosterName("Sandy");

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(pc).getPost(1);
        doReturn(post).when(pc).getAllPostsByName("Sandy");
        doReturn(post).when(pc).createPost(post1);
        doReturn(postList).when(pc).getAllPosts();
    }

    private void setUpCommentClientMocks(){
        cc = mock(CommentClient.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,27));
        comment.setCommenterName("Heather");
        comment.setComment("Check out my twitter account!");

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019,9,27));
        comment1.setCommenterName("Heather");
        comment1.setComment("Check out my twitter account!");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(comment).when(cc).getComment(1);
        doReturn(comment).when(cc).getAllCommentsByName("Heather");
        doReturn(comment).when(cc).getAllCommentsByPostId(1);
        doReturn(commentList).when(cc).getAllComments();
    }


    @Test
    public void createGetPost() {
        
    }

    @Test
    public void getAllPosts() {
    }

    @Test
    public void getAllPostsByName() {
    }

    @Test
    public void createGetComment() {}

    @Test
    public void getAllCommentsByName() {}

    @Test
    public void getAllCommentsByPostId() {

    }

    @Test
    public void getAllComments() {}
}