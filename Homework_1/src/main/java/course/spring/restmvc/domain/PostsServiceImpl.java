package course.spring.restmvc.domain;

import course.spring.restmvc.dao.PostsRepository;
import course.spring.restmvc.exception.NonexisitngEntityException;
import course.spring.restmvc.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository repo;

    @Override
    public Post add(Post post) {
        return repo.insert(post);
    }

    @Override
    public List<Post> findAll() {
        return repo.findAll();
    }

    @Override
    public Post update(Post post) {
        Optional<Post> old=repo.findById(post.getId());
        if(!old.isPresent()){
            throw new NonexisitngEntityException( String.format("Post wit ID '%s' does not exist",post.getId()));
        }
        post.setCreated(old.get().getCreated());
        post.setAuthor(old.get().getAuthor());
        post.setActiveStatus((old.get().isActiveStatus()));
        post.setContent(old.get().getContent());
        post.setTitle(old.get().getTitle());
        post.setTags(old.get().getTags());
        return repo.save(post);
    }

    @Override
    public Post findById(String postId) {
        return repo.findById(postId).orElseThrow(()->new NonexisitngEntityException (
                    String.format("Post with ID '%s' does not exist",postId)));
        }
}
