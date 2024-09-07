package com.example.Class_15_MinorProject;

import com.example.Class_15_MinorProject.controller.StudentController;
import com.example.Class_15_MinorProject.dto.CreateStudentRequest;
import com.example.Class_15_MinorProject.dto.SearchRequest;
import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {


    @InjectMocks
    StudentController studentController;

    @MockBean
    StudentService studentService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testCreateStudent_Success() throws Exception {

        CreateStudentRequest createStudentRequest = CreateStudentRequest.builder()
                .name("Ashish")
                .email("ashish@gmail.com")
                .age(12)
                .rollNumber("124")
                .build();


        // POST API with valid JSON body
        mockMvc.perform(post("/student/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createStudentRequest)))
            .andExpect(status().isCreated())
            .andExpect(content().string(equalTo("Student got added successfully")));
    }

    @Test
    public void testFindStudent_Success() throws Exception {

        SearchRequest searchRequest = SearchRequest.builder()
                .searchKey("id")
                .searchValue("1")
                .build();

        Student expectedStudent = Student.builder()
                .id(1)
                .name("John")
                .age(12)
                .email("searchValue")
                .rollNumber("12")
                .build();

        when(studentService.findStudent(searchRequest.getSearchKey(), searchRequest.getSearchValue()))
                .thenReturn(expectedStudent);


        // POST API with valid JSON body
        mockMvc.perform(get("/student/find")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(expectedStudent.to())));
    }

    @Test
    public void testFindStudent_BadRequest() throws Exception {

        SearchRequest searchRequest = SearchRequest.builder()
                .searchKey("invalidKey")
                .searchValue("1")
                .build();

        when(studentService.findStudent(searchRequest.getSearchKey(), searchRequest.getSearchValue()))
                .thenThrow(new Exception("Search key is not valid"));


        // POST API with valid JSON body
        mockMvc.perform(get("/student/find")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchRequest)))
                .andExpect(status().isBadRequest());
    }




}
