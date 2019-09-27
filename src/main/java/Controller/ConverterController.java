package Controller;

import domain.DemoObj;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    @RequestMapping(value = "/convert",produces = {"application/x-wisely"})
    public @ResponseBody DemoObj conver(@RequestBody DemoObj demoObj){
                    return demoObj;
    }

}
