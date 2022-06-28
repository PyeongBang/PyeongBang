package com.project.PyeongBang.PB.controller;

import com.project.PyeongBang.common.myapp.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MainControllerTest.class)
@ContextConfiguration(classes = {WebConfig.class})
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void MainPage() throws Exception{
        String content = "content";

        mvc.perform(get("/main")
                .content(content))
                .andExpect(status().isOk());
    }
}
