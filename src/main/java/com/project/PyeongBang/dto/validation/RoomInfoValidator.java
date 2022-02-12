package com.project.PyeongBang.dto.validation;

import com.project.PyeongBang.dto.RoomInfoDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.Field;


public class RoomInfoValidator implements Validator {
    @Override
    public boolean supports(Class clazz) { return RoomInfoDto.class.equals(clazz); }

    public void validate(Object obj, Errors e){

        RoomInfoDto rid = (RoomInfoDto) obj;
        try{
            Object obj2 = rid;
            for(Field field : obj2.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                System.out.println(value);
                if(value == null || value.toString().length() < 1){
                    e.reject("필수 값 오류", "필수 값을 입력해주세요");
                }
            }
        } catch(Exception ee){
            ee.printStackTrace();
        }
    }
}
