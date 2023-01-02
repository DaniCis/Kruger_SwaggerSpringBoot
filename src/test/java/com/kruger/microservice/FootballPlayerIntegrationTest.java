package com.kruger.microservice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.kruger.microservice.model.FootBallPlayer;
import com.kruger.microservice.model.repository.FootballPlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class FootballPlayerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FootballPlayerRepository repo;

    @Test
    public void testDeleteFootballPlayers() throws Exception{
        Integer playerID= 5;
        String url ="http://localhost:8080/footballplayer/delete/"+ playerID;
        this.mockMvc.perform(delete(url)).andExpect(status().isOk());
        Optional<FootBallPlayer> result = repo.findById(playerID);
        assertThat(result).isNotPresent();
    }

    @Test
    public void testListFootballPlayers() throws Exception{
        String url ="http://localhost:8080/footballplayer";

        MvcResult mvcResult = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(jsonResponse);
    }

}
