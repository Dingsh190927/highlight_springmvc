package Interceptor;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // return super.preHandle(request, response, handler);
        Long starTime=System.currentTimeMillis();
        request.setAttribute("starTime",starTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //super.postHandle(request, response, handler, modelAndView);
        Long starTime= (Long) request.getAttribute("starTime");
        request.removeAttribute("starTime");
        Long endTime=System.currentTimeMillis();
        System.out.println("花费的时间" +new Long( endTime-starTime));
            request.setAttribute("handlerTime ", endTime-starTime);
    }

}
