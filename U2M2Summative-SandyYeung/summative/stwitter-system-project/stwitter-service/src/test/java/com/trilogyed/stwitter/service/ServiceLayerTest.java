package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.CommentViewModel;
import com.trilogyed.stwitter.domain.Post;
import com.trilogyed.stwitter.domain.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    PostClient pc;
    CommentClient cc;

    private static final List<String> STRING_COMMENTS = new ArrayList<>(Arrays.asList("Check out my twitter account!"));
    private static final CommentViewModel CVM_INPUT = new CommentViewModel(1, LocalDate.of(2019, 9, 27), "Heather", "Check out my twitter account!");
    private static final CommentViewModel CVM_OUTPUT = new CommentViewModel(1, 1, LocalDate.of(2019, 9, 27), "Heather", "Check out my twitter account!");
    private static final PostViewModel PVM_INPUT = new PostViewModel("First tweet", LocalDate.of(2019, 9, 26), "Sandy", STRING_COMMENTS);
    private static final PostViewModel PVM_OUTPUT = new PostViewModel(1, "First tweet", LocalDate.of(2019, 9, 26), "Sandy", STRING_COMMENTS);

    private static final Comment COMMENT_INPUT = new Comment(1, LocalDate.of(2019, 9, 27), "Heather", "Check out my twitter account!");
    private static final Comment COMMENT_OUTPUT = new Comment(1, 1, LocalDate.of(2019, 9, 27), "Heather", "Check out my twitter account!");
    private static final Post POST_INPUT = new Post("First tweet", LocalDate.of(2019, 9, 26), "Sandy", STRING_COMMENTS);
    private static final Post POST_OUTPUT = new Post(1, "First tweet", LocalDate.of(2019, 9, 26), "Sandy", STRING_COMMENTS);

    @Before
    public void setUp() throws Exception {
        setUpPostClientMocks();
        setUpCommentClientMocks();
        serviceLayer = new ServiceLayer(pc, cc);
    }

    private void setUpPostClientMocks() {
        pc = mock(PostClient.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 27));
        comment.setCommenterName("Heather");
        comment.setComment("Check out my twitter account!");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        List<String> stringComments = new ArrayList<>();
        for (Comment c : commentList) {
            stringComments.add(c.getComment());
        }

        Post post = new Post();
        post.setPostId(1);
        post.setPost("First tweet.");
        post.setPostDate(LocalDate.of(2019, 9, 26));
        post.setPosterName("Sandy");
        post.setComments(stringComments);

        Post post1 = new Post();
        post1.setPost("First tweet.");
        post1.setPostDate(LocalDate.of(2019, 9, 26));
        post1.setPosterName("Sandy");
        post1.setComments(stringComments);

        doReturn(post).when(pc).createPost(post1);
        doReturn(post).when(pc).getPost(1);

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(postList).when(pc).getAllPosts();
        doReturn(postList).when(pc).getAllPostsByName("Sandy");
//        doReturn(POST_OUTPUT).when(pc).createPost(POST_INPUT);
//        doReturn(POST_OUTPUT).when(pc).getPost(1);
//
//        List<Post> postList = new ArrayList<>();
//        postList.add(POST_INPUT);
//
//        doReturn(postList).when(pc).getAllPostsByName("Sandy");
//        doReturn(postList).when(pc).getAllPosts();
    }

    private void setUpCommentClientMocks() {
        cc = mock(CommentClient.class);

        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 27));
        comment.setCommenterName("Heather");
        comment.setComment("Check out my twitter account!");

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019, 9, 27));
        comment1.setCommenterName("Heather");
        comment1.setComment("Check out my twitter account!");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(comment).when(cc).getComment(1);
        doReturn(commentList).when(cc).getAllComments();
        doReturn(commentList).when(cc).getAllCommentsByName("Heather");
        doReturn(commentList).when(cc).getAllCommentsByPostId(1);

//        List<Comment> commentList = new ArrayList<>();
//        commentList.add(COMMENT_INPUT);
//
//        doReturn(COMMENT_OUTPUT).when(cc).getComment(1);
//        doReturn(commentList).when(cc).getAllCommentsByName("Heather");
//        doReturn(commentList).when(cc).getAllCommentsByPostId(1);
//        doReturn(commentList).when(cc).getAllComments();
    }

    @Test
    public void createGetUpdateDeleteGetAllPost() {
        List<Comment> commentsList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 9, 27));
        comment.setCommenterName("Heather");
        comment.setComment("Check out my twitter account!");

        commentsList.add(comment);

        List<String> stringComments = new ArrayList<>();
        for (Comment c : commentsList) {
            stringComments.add(c.getComment());
        }

        PostViewModel pvm = new PostViewModel();
        pvm.setPost("First tweet.");
        pvm.setPostDate(LocalDate.of(2019, 9, 26));
        pvm.setPosterName("Sandy");
        pvm.setComments(stringComments);

        List<PostViewModel> allList = new ArrayList<>();
        allList.add(pvm);

        pvm = serviceLayer.createPost(pvm);
        PostViewModel fromService = serviceLayer.getPost(pvm.getPostId());
        assertEquals(pvm, fromService);

        List<PostViewModel> pvmList = serviceLayer.getAllPosts();
        assertEquals(allList, pvmList);
    }

    @Test
    public void getAllPostsByName() {

    }

    @Test
    public void createGetUpdateDeleteGetAllComment() {
    }

    @Test
    public void getAllCommentsByName() {
    }

    @Test
    public void getAllCommentsByPostId() {

    }
}