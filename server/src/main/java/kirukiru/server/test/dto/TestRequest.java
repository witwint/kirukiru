package kirukiru.server.test.dto;

import kirukiru.server.test.domain.TestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TestRequest {

    private String testProduct;

    private String testPrice;


    public static TestRequest toDto(TestEntity testEntity) {
        TestRequest testRequest = TestRequest.builder()
                .testProduct(testEntity.getTestProduct())
                .testPrice(testEntity.getTestPrice())
                .build();
        return testRequest;
    }
}