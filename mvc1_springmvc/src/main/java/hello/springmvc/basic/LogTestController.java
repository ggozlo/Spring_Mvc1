package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 로거 획득 어노테이션
@RestController
public class LogTestController {

  //  private final Logger log = LoggerFactory.getLogger(getClass()); // 로거 획득

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);


        log.trace("trace log ="+ name); // 이거는 로그레벨에 의해 출력되지 않아도 문자열 연산이 되어버림

        // log Level : trace > debug > info > warn > error , default = info
        log.trace("trace log = {}", name); // 로그 표현식은 {} 에 뒤의 파라미터값이 들어간다, 여러개 가능
        log.debug("debug log = {}", name);
        log.info(" info log = {}", name);
        log.warn(" warn log={}", name);
        log.error(" error={}", name);

        return "ok";
    }

}
