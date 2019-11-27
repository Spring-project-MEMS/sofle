package course.spring.restmvc.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Document("users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String role;
    private String URLofImg;
}
