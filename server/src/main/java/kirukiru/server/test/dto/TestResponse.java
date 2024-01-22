package kirukiru.server.test.dto;

import kirukiru.server.test.domain.TestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TestResponse {

    private String testProduct;

    private String testPrice;

    private LocalDateTime getCreatedAt;

    private LocalDateTime getUpdateAt;

    public static TestResponse toDto(TestEntity testEntity) {
        TestResponse testResponse = TestResponse.builder()
                .testProduct(testEntity.getTestProduct())
                .testPrice(testEntity.getTestPrice())
                .getCreatedAt(testEntity.getCreatedAt())
                .getUpdateAt(testEntity.getUpdateAt())
                .build();
        return testResponse;
    }
}
