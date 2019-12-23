package sustech.iot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }

    @RequestMapping("/led.html")
    public String led(){
        return "led";
    }
}
