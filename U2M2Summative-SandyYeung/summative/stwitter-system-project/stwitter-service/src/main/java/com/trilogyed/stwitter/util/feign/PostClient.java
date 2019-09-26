package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.domain.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
