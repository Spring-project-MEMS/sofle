package course.spring.restmvc.domain;

import course.spring.restmvc.model.Post;

import java.util.List;

public interface PostsService {
    Post add(Post post);
    List<Post> findAll();
    Post findById(String postId);
    Post update(Post post);

}
