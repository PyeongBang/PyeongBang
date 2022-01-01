package com.project.PyeongBang.dto.validation;

import com.project.PyeongBang.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    public boolean supports(Class clazz){
        return UserDto.class.equals(clazz);
    }

    public void validate(Object obj, Errors e){
        UserDto u = (UserDto) obj;
        if(u.getId().length() < 3){
            e.reject("id 오류", "id는 3자리 이상 입력해주세요");
        }
        else if(u.getName().length() < 1){
            e.reject("name 오류", "name는 1자리 이상 입력해주세요");
        }
        else if(u.getPwd().length() < 7){
            e.reject("pw 오류", "pw는 7자리 이상 입력해주세요");
        }
    }
}
