package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1") // ModelAndView 방식으로 View 렌더링
    public ModelAndView responseViewV1() {

        ModelAndView mav = new ModelAndView("/response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2") // 템플릿의 주소로 렌더링
    public String responseViewV2(Model model) {

        model.addAttribute("data", "hello!");

        return "/response/hello";
    }

    @RequestMapping("/response/hello") // 경로명이 일치하면
    public void responseViewV3(Model model) {

        model.addAttribute("data", "hello!");
    }

}
