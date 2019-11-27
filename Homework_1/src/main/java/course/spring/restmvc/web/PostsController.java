package course.spring.restmvc.web;

import course.spring.restmvc.domain.PostsService;
import course.spring.restmvc.exception.InvalidEntityException;
import course.spring.restmvc.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping
    List<Post> getPosts(){
        return postsService.findAll();
    }

    @GetMapping("{id}")
    public Post getPostById(@PathVariable("id") String postId){
        return postsService.findById(postId);
    }


    @PostMapping
    ResponseEntity<Post> addPost(@RequestBody Post post, UriComponentsBuilder uriBuilder, HttpServletRequest req) {
        Post created = postsService.add(post);
        return ResponseEntity.created(uriBuilder.path(req.getServletPath()).pathSegment("{id}").build(created.getId())).body(created);
    }

    @PutMapping("{id}")
    public Post update(@PathVariable String id, @RequestBody Post post){

        if (!id.equals(post.getId())) {
            throw new InvalidEntityException(
                    String.format("Entity ID='%s'different from URL resourse= '%s'",post.getId(),id)) ;
        }
        return postsService.update(post);
    }

}
