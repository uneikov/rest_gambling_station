package com.uran.rest_gambling_station;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uran.rest_gambling_station.domain.Stake;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static com.uran.rest_gambling_station.data.StakeTestData.STAKE_1;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StakeRestControllerTest {
    private static final Logger LOG = getLogger(StakeRestControllerTest.class);
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper mapper;
    
    //private JacksonTester<Stake> json;
    
   /* @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Possibly configure the mapper
        JacksonTester.initFields(this, objectMapper);
    }*/
    
    @Test
    @WithMockUser(username = "User1", password = "password1", roles = "USER")
    public void shouldReturnStakeForStakeId() throws Exception {
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        final ResultActions resultActions = this.mockMvc.perform(get("/stakes/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_UTF8_VALUE))
                //.andExpect(content().json(mapper.writeValueAsString(STAKE_1), true));
                .andExpect(content().json(mapper.writeValueAsString(STAKE_1), true));
        
        //final JsonContent<Stake> content = this.json.write(STAKE_1);
        
        final String s = mapper.writeValueAsString(STAKE_1);
        final String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        //Stake stake = mapper.readValue(contentAsString, TypeFactory.defaultInstance().constructType(Stake.class));
        Stake stake1 = mapper.reader().forType(Stake.class).readValue(s);
        final String s1 = STAKE_1.toString();
        Assert.assertEquals(String.valueOf(stake1), String.valueOf(STAKE_1));
    }
    
    @Test
    @WithMockUser(username = "User1", password = "password1", roles = "USER")
    public void shouldReturnStakesForRaceId() throws Exception {
        this.mockMvc.perform(get("/race/1/stakes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(STAKE_1)), true));
    }
    
    @Test
    @WithMockUser(username = "User1", password = "password1", roles = "USER")
    public void shouldReturnStakesForRaceIdAndUserId() throws Exception {
        this.mockMvc.perform(get("/race/1/stakes/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(STAKE_1)), true));
    }
    
    @Test
    @WithMockUser(username = "User1", password = "password1", roles = "USER")
    public void shouldReturnAllStakes() throws Exception {
        this.mockMvc.perform(get("/stakes"))
                .andDo(print())
                .andExpect(status().isForbidden());
                //.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_UTF8_VALUE));
                //.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(STAKE_1)), true));
    }
}
