package s1510.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

@Entity
@Profile(value = {"dev", "prod", "test"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IMAGES_ENTITIES")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonIgnore
    private TeamManager teamManager;
    @Column(name = "url")
    private String url;
    @Column(name = "image_id")
    private String image_id;
    @Column(name = "image_name")
    private String image_name;
}