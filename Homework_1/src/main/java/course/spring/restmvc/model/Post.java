package course.spring.restmvc.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Document("posts")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String author;
    private ArrayList<String> tags=new ArrayList<>();
    @NonNull
    private LocalDateTime created = LocalDateTime.now();
    private String URLofImg;
    private boolean activeStatus=true;
}
