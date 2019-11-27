package course.spring.restmvc.domain;

import course.spring.restmvc.model.User;

import java.util.List;

public interface UsersService {
    List<User> findAll();
    User add(User  user);
    User findById(String userId);
    User update(User user);

}
