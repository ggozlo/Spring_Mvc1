package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // body 의 내용을 바이트 코드로 획득
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 스트림을 문자열 변환을 지원하는 스프링 제공 라이브러리

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");

    }

}
