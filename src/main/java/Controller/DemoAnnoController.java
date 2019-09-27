package Controller;

import domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
@RequestMapping(produces = "text/plain;charset=utf-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access";
        }
 @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=utf-8")
    public  @ResponseBody String demoPathver(@PathVariable String str,HttpServletRequest request){
        return "url:"+request.getRequestURI()+"  can access,str "+ str;
 }

 @RequestMapping(value = "/requestParam",produces = "text/plain;charset=utf-8")
    public @ResponseBody String passRequestParam( Long id,HttpServletRequest request){
        return  "url:"+request.getRequestURI()+"  can access,id "+ id;
 }
 @RequestMapping(value = "/obj",produces = "application/json;charset=utf-8")
 @ResponseBody
 public  String passobj( DemoObj obj, HttpServletRequest request){
     return  "url:"+request.getRequestURI()+"  can access,obj id  "+ obj.getId()+" obj name " + obj.getName();
 }

    @RequestMapping(value ={"/name1","/name2"},produces = "text/plain;charset=utf-8")
    @ResponseBody
    public  String remove( HttpServletRequest request){
        return  "url:"+request.getRequestURI();
    }
}
