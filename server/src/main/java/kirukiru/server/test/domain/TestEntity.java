package kirukiru.server.test.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Getter
@Builder
@Setter
public class TestEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id; // PK로 활용하기 위한 id값

    private String testProduct;

    private String testPrice;

    public TestEntity(String testProduct, String testPrice) {
        this.testProduct = testProduct;
        this.testPrice = testPrice;
    }
}