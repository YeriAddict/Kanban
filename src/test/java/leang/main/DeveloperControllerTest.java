package leang.main;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DeveloperControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Test
    public void findAllDevelopersTest() throws Exception {
        
        mvc.perform(get("/developers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstname", is("Joo-hyun")))
                .andExpect(jsonPath("$[0].lastname", is("Bae")))
                .andExpect(jsonPath("$[0].password", is("Irene")))
                .andExpect(jsonPath("$[0].email", is("rv_irene@gmail.com")))
                .andExpect(jsonPath("$[0].startContract", is("1991-03-29")));
    }
    
}
