package com.examly.springapp;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Test;
import org.junit.jupiter.api.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	@Transactional
    public void BE_Add_AppliedJob() throws Exception {
        String newJob = "{\"jobId\":\"JobID01\",\"employeeId\":\"02\",\"appliedDate\":\"15.09.2021\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/home")
		.param("valutId","VID01")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newJob)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_AppliedJob() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/home")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Add_Job() throws Exception {
        String newJob = "{\"jobTitle\":\"Manager\",\"jobLocation\":\"coimbatore\",\"jobType\":\"full time\",\"jobDesc\":\"customer success manager\",\"salary\":\"38000\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/hr/addJob")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newJob)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_HR() throws Exception {
        String newHR = "{\"email\":\"hr1@gmail.com\",\"password\":\"HR@123\",\"username\":\"HR1\",\"mobileNumber\":\"9876543210\",\"department\":\"HR\",\"role\":\"HR\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/update")
		.param("email","hr1@gmail.com")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newHR)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
}
