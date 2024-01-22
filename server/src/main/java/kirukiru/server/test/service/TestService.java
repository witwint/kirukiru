package kirukiru.server.test.service;

import kirukiru.server.test.domain.TestEntity;
import kirukiru.server.test.dto.TestRequest;
import kirukiru.server.test.dto.TestResponse;
import kirukiru.server.test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    @Transactional
    public TestResponse save(TestRequest testRequest) {
        TestEntity testEntity = new TestEntity(testRequest.getTestProduct(),
                testRequest.getTestPrice());
        testRepository.save(testEntity);
        return TestResponse.toDto(testEntity);
    }

    @Transactional
    public List<TestResponse> getTestAll() {
        List<TestResponse> testResponseList = new ArrayList<>();
        List<TestEntity> testEntityList = testRepository.findAll();
        for (TestEntity testEntity : testEntityList) {
            testResponseList.add(TestResponse.toDto(testEntity));
        }
        return testResponseList;
    }

    @Transactional
    public String deleteAllTest() {
        testRepository.deleteAll();
        return "success deleteAllTest";
    }

}