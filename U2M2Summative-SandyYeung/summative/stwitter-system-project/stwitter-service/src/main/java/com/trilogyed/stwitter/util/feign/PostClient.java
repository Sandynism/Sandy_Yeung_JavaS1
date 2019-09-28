package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.domain.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostClient {

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    Post createPost(@RequestBody Post post);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    Post getPost(@PathVariable int id);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    void updatePost(@RequestBody Post post, @PathVariable int id);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    void deletePost(@PathVariable int id);

    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    List<Post> getAllPostsByName(@PathVariable String posterName);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    List<Post> getAllPosts();

}
