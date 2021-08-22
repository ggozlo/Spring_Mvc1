package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={} age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2") // 기본적인 @RequestParam 사용법
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {

        log.info("username={} age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3") // 변수명이 같다면 name 생략 가능
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {

        log.info("username={} age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4") // 변수명이 같다면  @RequestParam 자체를 생략도 가능
    public String requestParamV4(String username, int age) {

        log.info("username={} age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required") // required 가 false 면 해당 파라미터가 들어오지 않아도됨, true 는 기본값, 오류남
    public String requestParamRequired(@RequestParam(required = true) String username,
                                       @RequestParam(required = false) Integer age) {

        log.info("username={} age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default") // 기본값 empty 이거나 null 이면 지정된 기본값 으로 설정됨
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                      @RequestParam(defaultValue = "-1") Integer age) {

        log.info("username={} age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map") // Map 으로 파라미터를 바인딩 할수도 있다 @RequestParam 필수
    public String requestParamMap(@RequestParam Map<String, String> paramMap) {

        log.info("username={} age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1") // 파라미터명 으로 setter 를 호출해서 객체의 값을 바인딩 해줌
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}",  helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2") // 어노테이션 생략 가능
    public String modelAttributeV2(HelloData helloData) {

        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}",  helloData);

        return "ok";
    }
}
