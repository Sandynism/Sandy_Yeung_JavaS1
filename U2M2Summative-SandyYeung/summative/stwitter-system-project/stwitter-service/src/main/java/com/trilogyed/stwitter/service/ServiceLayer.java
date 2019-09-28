package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.domain.Comment;
import com.trilogyed.stwitter.domain.CommentViewModel;
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

    public PostViewModel createPost(PostViewModel pvm) {
        Post post = new Post();
        post.setPost(pvm.getPost());
        post.setPostDate(pvm.getPostDate());
        post.setPosterName(pvm.getPosterName());
        post.setComments(pvm.getComments());

        pvm.setPostId(post.getPostId());
        pvm.setPost(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setComments(post.getComments());

        return pvm;
    }

    public PostViewModel getPost(int postId) {
        return buildPostViewModel(postId);
    }

    public List<PostViewModel> getAllPostsByName(String posterName) {
        List<Post> postList = postClient.getAllPostsByName(posterName);
        List<PostViewModel> pvm = new ArrayList<>();

        for (Post p : postList) {
            pvm.add(buildPostViewModel(p.getPostId()));
        }
        return pvm;
    }

    public List<PostViewModel> getAllPosts() {
        List<Post> postList = postClient.getAllPosts();
        List<PostViewModel> pvm = new ArrayList<>();

        for (Post p : postList) {
            pvm.add(buildPostViewModel(p.getPostId()));
        }

        return pvm;
    }

//    public void updatePost(PostViewModel pvm) {
//        Post post = new Post();
//        post.setPostId(pvm.getPostId());
//        post.setPost(pvm.getPost());
//        post.setPostDate(pvm.getPostDate());
//        post.setPosterName(pvm.getPosterName());
//        post.setComments(pvm.getComments());
//
//        postClient.updatePost(post, post.getPostId());
//    }
//
//    public void deletePost(int postId) {
//        postClient.deletePost(postId);
//    }

    public CommentViewModel createComment(CommentViewModel cvm) {
        Comment comment = new Comment();
        comment.setPostId(cvm.getPostId());
        comment.setCreateDate(cvm.getCreateDate());
        comment.setCommenterName(cvm.getCommenterName());
        comment.setComment(cvm.getComment());

        commentClient.createComment(comment);

        cvm.setCommentId(comment.getCommentId());
        cvm.setPostId(comment.getPostId());
        cvm.setCreateDate(comment.getCreateDate());
        cvm.setCommenterName(comment.getCommenterName());
        cvm.setComment(comment.getComment());

        return cvm;
    }

    public CommentViewModel getComment(int commentId) {
        return buildCommentViewModel(commentId);
    }

    public List<CommentViewModel> getAllComments() {
        List<Comment> commentsList = commentClient.getAllComments();
        List<CommentViewModel> cvm = new ArrayList<>();

        for (Comment c : commentsList) {
            cvm.add(buildCommentViewModel(c.getCommentId()));
        }
        return cvm;
    }

    public List<CommentViewModel> getAllCommentsByName(String commenterName) {
        List<Comment> commentsList = commentClient.getAllCommentsByName(commenterName);
        List<CommentViewModel> cvm = new ArrayList<>();

        for (Comment c : commentsList) {
            cvm.add(buildCommentViewModel(c.getCommentId()));
        }
        return cvm;
    }

    public List<CommentViewModel> getAllCommentsByPostId(int postId) {
        List<Comment> commentsList = commentClient.getAllCommentsByPostId(postId);
        List<CommentViewModel> cvm = new ArrayList<>();

        for (Comment c : commentsList) {
            cvm.add(buildCommentViewModel(c.getCommentId()));
        }
        return cvm;
    }

    private PostViewModel buildPostViewModel(int postId) {
        List<Comment> commentsList = commentClient.getAllCommentsByPostId(postClient.getPost(postId).getPostId());
        List<String> stringComments = new ArrayList<>();
        for (Comment c : commentsList) {
            stringComments.add(c.getComment());
        }

        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(postClient.getPost(postId).getPostId());
        pvm.setPost(postClient.getPost(postId).getPost());
        pvm.setPostDate(postClient.getPost(postId).getPostDate());
        pvm.setPosterName(postClient.getPost(postId).getPosterName());
        pvm.setComments(stringComments);

        return pvm;
    }

    private CommentViewModel buildCommentViewModel(int commentId) {
        CommentViewModel cvm = new CommentViewModel();
        cvm.setCommentId(commentClient.getComment(commentId).getCommentId());
        cvm.setPostId(commentClient.getComment(commentId).getPostId());
        cvm.setCreateDate(commentClient.getComment(commentId).getCreateDate());
        cvm.setCommenterName(commentClient.getComment(commentId).getCommenterName());
        cvm.setComment(commentClient.getComment(commentId).getComment());

        return cvm;
    }
}
