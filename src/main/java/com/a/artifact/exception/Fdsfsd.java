package com.a.artifact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-20 22:05
 */

@ControllerAdvice
public class Fdsfsd {
    @ModelAttribute(binding = true)
    public void presetParam(Model model){
        model.addAttribute("globalAttr","this is a global attribute");
    }

    @ModelAttribute(binding = true , value="myMap")
    public Map<String, String> presetParam(){
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        return map1;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String fdsfwwersf(MyException m) {
        Map<String ,Object> map = new HashMap<>();
        map.put("id",m.getId());
        map.put("message",m.getMessage());
        return "A ha";
    }
    // 该方法无效 , 待修改
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String,Object> handlerValidExistException(BindingResult result) {
        Map<String ,Object> map = new HashMap<>();
        if (result != null) {
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                for (int i = 0; i < errors.size(); i++) {
                    map.put(Integer.toString(i),errors.get(i).getObjectName());
                }
            }
        } else {
            map.put("field","result is null");
        }
        return map;
    }
}