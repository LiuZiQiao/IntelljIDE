package com.lxk.demo.exception;

import com.lxk.demo.model.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ProjExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e)throws Exception{

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.setViewName("error");
        return mav;
    }

    public ErrorInfo<String> jsonErrorxHandler(HttpServletRequest request, ProjException e){
        ErrorInfo<String> r = new ErrorInfo<>();

        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.getERROR());
        r.setDate("Some Data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }
}
