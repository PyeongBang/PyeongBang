package com.project.PyeongBang.PB.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.PyeongBang.common.myapp.WebConfig;
import com.project.PyeongBang.controller.UserController;
import com.project.PyeongBang.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {WebConfig.class})

//@ComponentScan(basePackages = "com.project.PyeongBang.controller")
public class UserControllerTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void postsLogin() throws Exception{
        String id = "id";
        String name = "name";

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);

        String content = objectMapper.writeValueAsString(userDto);

        // 필수값이 없을 경우 badRequest 에러
        mvc.perform(post("/login")
                .content(content))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }



}
