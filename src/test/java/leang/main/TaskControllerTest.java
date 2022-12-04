package leang.main;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Iterator;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import leang.main.entities.Task;
import leang.main.entities.TaskStatus;
import leang.main.entities.TaskType;
import leang.main.services.TaskService;
import leang.main.structs.Status;
import leang.main.structs.Type;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private TaskService taskService;
    
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
    
    @Test
    public void createTaskTest() throws Exception {
        Task taskTest = new Task("ReVe Festival 2022", 0, 0, LocalDate.of(2022, Month.MARCH, 22));
        taskTest.setTaskStatus(new TaskStatus(Status.STATUS_TWO_ID, Status.STATUS_TWO_LABEL));
        taskTest.setTaskType(new TaskType(Type.TYPE_ONE_ID, Type.TYPE_ONE_LABEL));
        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        byte[] task = mapper.writeValueAsBytes(taskTest);
        mvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON).content(task))              
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        Collection<Task> tasks = this.taskService.findAllTasks();
        Assert.assertEquals(3, tasks.size());
    }
    
    @Test
    public void moveTaskTest() throws Exception {
        Collection<Task> tasks = this.taskService.findAllTasks();
        Task task = tasks.iterator().next();
        Iterator<Task> iterator = tasks.iterator();
        while(iterator.hasNext()) {
            task = iterator.next();
        }
        
        mvc.perform(patch("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON).content("RIGHT"))             
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        mvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[1].taskStatus.label", is("WORK_DONE")));
        
        mvc.perform(patch("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON).content("LEFT"))             
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        mvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[1].taskStatus.label", is("WORK_TO_TEST")));
    }
    
}
