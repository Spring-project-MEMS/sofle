package course.spring.restmvc.domain;

import course.spring.restmvc.dao.UsersRepository;
import course.spring.restmvc.exception.NonexisitngEntityException;
import course.spring.restmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User add(User user) {
        return repo.insert(user);
    }

    @Override
    public User findById(String userId) {
        return repo.findById(userId).orElseThrow(()->new NonexisitngEntityException (
                String.format("Post with ID '%s' does not exist",userId)));
    }

    @Override
    public User update(User user) {
        Optional<User> old=repo.findById(user.getId());
        if(!old.isPresent()){
            throw new NonexisitngEntityException( String.format("User with ID '%s' does not exist",user.getId()));
        }
        return repo.save(user);
    }
}
