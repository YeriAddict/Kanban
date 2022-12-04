package leang.main;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Test
    public void findAllTasksTest() throws Exception {
        
        mvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("ReVe Festival 2022")))
                .andExpect(jsonPath("$[0].nbHoursForecast", is(0)))
                .andExpect(jsonPath("$[0].nbHoursReal", is(0)))
                .andExpect(jsonPath("$[0].created", is("2022-03-22")))
                .andExpect(jsonPath("$[0].developers", is(Matchers.empty())))
                .andExpect(jsonPath("$[0].taskStatus.label", is("WORK_ON_PROGRESS")))
                .andExpect(jsonPath("$[0].taskType.label", is("FEATURE_TO_CREATE")));
    }
    
    @Test
    public void findAllTaskStatusTest() throws Exception {
        
        mvc.perform(get("/task_status")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].label", is("WORK_TO_DO")));
    }
    
    @Test
    public void findAllTaskTypesTest() throws Exception {
        
        mvc.perform(get("/task_types")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].label", is("FEATURE_TO_CREATE")));
    }
    
}
