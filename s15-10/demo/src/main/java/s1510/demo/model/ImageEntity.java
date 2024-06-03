package s1510.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
    private TeamManager teamManager;
    @Column(name = "url")
    private String url;
    @Column(name = "image_id")
    private String image_id;
    @Column(name = "image_name")
    private String image_name;
}