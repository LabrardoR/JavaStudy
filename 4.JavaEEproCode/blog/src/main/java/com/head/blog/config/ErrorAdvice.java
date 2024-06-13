package com.head.blog.config;

import com.head.blog.common.Constants;
import com.head.blog.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody  // 因为返回的是result对象,而不是页面
@ControllerAdvice
public class ErrorAdvice {
    public Result errorhandler(Exception e){
        Result result = new Result<>();
        result.setErrorMsg("内部发生错误,请联系管理员");
        result.setCode(Constants.RESULT_FAIL);
        return result;
    }
}
