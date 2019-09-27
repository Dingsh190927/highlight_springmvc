package messageconverter;

import domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {
    //构造
 public  MyMessageConverter(){
     super(new MediaType("application","x-wisely", Charset.forName("utf-8")));
 }

    @Override
    protected boolean supports(Class clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    @Override
public DemoObj readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException{
     String temp= StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("utf-8"));
     String[] tempAry=temp.split("-");
     return new DemoObj(new Long(tempAry[0]),tempAry[1]);

 }

    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String  out="hellow"+obj.getId()+"-"+obj.getName();
        outputMessage.getBody().write(out.getBytes());
    }







}
