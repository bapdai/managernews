package jwt.example.jwtspringboot.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @CreationTimestamp
    private Date createdAt;
    private String description;
    private String img;
    private String content;
    private Integer views = 1;
    private Boolean status;
    private String author;
}