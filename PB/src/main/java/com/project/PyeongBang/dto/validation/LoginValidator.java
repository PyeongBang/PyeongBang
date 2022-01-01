package com.project.PyeongBang.dto.validation;

import com.project.PyeongBang.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

    public boolean supports(Class clazz){ return UserDto.class.equals(clazz);}

    public void validate(Object obj, Errors e){
        UserDto u = (UserDto) obj;
        if(u.getId().length() < 1) {
            e.reject("id 오류", "id를 입력해주세요");
        }
        else if(u.getPwd().length() < 1){
            e.reject("pw 오류", "pw를 입력해주세요");
        }
    }
}
