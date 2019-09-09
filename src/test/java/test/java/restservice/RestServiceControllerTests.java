
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.java.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import config.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class RestServiceControllerTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Value("${error.text.emptyname}")
	private String emptyname;
	
	@Value("${error.text.notexistname}")
	private String notexistname;

    @Test
    public void noParamSwapiShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/swapi-proxy/person-info")).andDo(print()).andExpect(status().isNotFound())
        			.andExpect(jsonPath("$.message").value(emptyname));
                
    }

    @Test
    public void paramSwapiShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/swapi-proxy/person-info").param("name", "No existe"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(notexistname));
    }
    @Test
    public void paramSwapiShouldReturnOkMessage() throws Exception {

        this.mockMvc.perform(get("/swapi-proxy/person-info").param("name", "Luke Skywalker"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Luke Skywalker"));
    }

}
