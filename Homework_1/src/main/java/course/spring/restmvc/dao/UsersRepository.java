package course.spring.restmvc.dao;

import course.spring.restmvc.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User,String> {
}
