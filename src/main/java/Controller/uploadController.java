package Controller;

import ch.qos.logback.core.util.FileUtil;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class uploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){
       try{
           FileUtils.writeByteArrayToFile(new File("d:/upload/"+file.getOriginalFilename()),
           file.getBytes());
           return "0k";
       }catch (IOException e){
           e.printStackTrace();
           return  "error";
       }



    }
}
