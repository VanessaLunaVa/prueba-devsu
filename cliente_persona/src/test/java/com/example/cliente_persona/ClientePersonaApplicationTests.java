package com.example.cliente_persona;

import com.example.cliente_persona.infrastructure.adapter.in.controller.dto.ClienteRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientePersonaApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
        assertThat(true).isTrue();
	}

    @Test
    void crearCliente() throws Exception {
        ClienteRequest request = new ClienteRequest("VANESSA", "F", 30,
                "1190544886", "CALLE", "3166084957",
                "123-456-789", "PASS123", "A");

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/cliente")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
