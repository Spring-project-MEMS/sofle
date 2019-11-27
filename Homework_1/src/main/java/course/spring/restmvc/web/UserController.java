package course.spring.restmvc.web;

import course.spring.restmvc.domain.UsersService;
import course.spring.restmvc.exception.InvalidEntityException;

import course.spring.restmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UsersService usersService;

    @GetMapping
    List<User> getUsers(){
        return usersService.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") String userId){
        return usersService.findById(userId);
    }

    @PostMapping
    ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder uriBuilder, HttpServletRequest req) {
        User created = usersService.add(user);
        return ResponseEntity.created(uriBuilder.path(req.getServletPath()).pathSegment("{id}").build(created.getId())).body(created);
    }

    @PutMapping("{id}")
    public User update(@PathVariable String id, @RequestBody User user){

        if (!id.equals(user.getId())) {
            throw new InvalidEntityException(
                    String.format("Entity ID='%s'different from URL resourse= '%s'", user.getId(),id)) ;
        }
        return usersService.update(user);
    }
}
