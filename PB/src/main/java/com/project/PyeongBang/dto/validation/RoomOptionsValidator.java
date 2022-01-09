package com.project.PyeongBang.dto.validation;

import com.project.PyeongBang.dto.RoomOptionsDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.Field;


public class RoomOptionsValidator implements Validator {
    @Override
    public boolean supports(Class clazz) { return RoomOptionsDto.class.equals(clazz); }

    public void validate(Object obj, Errors e){

        RoomOptionsDto rod = (RoomOptionsDto) obj;
        try{
            Object obj2 = rod;
            for(Field field : obj2.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if(value == null || value.toString().length() < 1){
                    e.reject("필수 값 오류", "필수 값을 입력해주세요");
                }
            }
        } catch(Exception ee){
            ee.printStackTrace();
        }
    }
}
