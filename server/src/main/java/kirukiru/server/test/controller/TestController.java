package kirukiru.server.test.controller;

import kirukiru.server.test.dto.Response;
import kirukiru.server.test.dto.TestRequest;
import kirukiru.server.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    private final Response response;


    @PostMapping
    public ResponseEntity<?> addTest(@RequestBody TestRequest testRequest) {
        return response.success(testService.save(testRequest),"success", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTest() {
        return response.success(testService.getTestAll(),"success",HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        return response.success(testService.deleteAllTest(), "success", HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> getTest() {
        return response.success("테스트성공","success",HttpStatus.OK);
    }

    @GetMapping("/text")
    public ResponseEntity<?> getText() {
        return response.success("test CICD15dev","success",HttpStatus.OK);
    }

}