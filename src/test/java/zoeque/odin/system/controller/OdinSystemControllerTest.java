package zoeque.odin.system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import zoeque.odin.system.domain.entity.OdinSystem;
import zoeque.odin.system.domain.repository.OdinSystemRepository;
import zoeque.odin.system.dto.OdinSystemDto;
import zoeque.odin.system.controller.OdinSystemController;
import zoeque.odin.tool.DatabaseDropService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OdinSystemControllerTest {
  private MockMvc mvc;
  @Autowired
  DatabaseDropService dropService;
  @Autowired
  ObjectMapper mapper;
  @Autowired
  OdinSystemController controller;
  @Autowired
  OdinSystemRepository repository;

  @BeforeEach
  public void cleanup() {
    dropService.deleteAll();
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void sendMockRestRequest_attemptToCreate_return200() throws Exception {
    mvc.perform(post("/system/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(""))
            .andExpect(status().isOk());
  }

  @Test
  public void givenOdinSystemInDb_whenAttemptToEdit_returns200() throws Exception {
    repository.save(new OdinSystem(false, false, 1, 1));

    OdinSystemDto dto = new OdinSystemDto(true, true, 1, 1);
    String json = mapper.writeValueAsString(dto);

    mvc.perform(post("/system/edit")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json)).andExpect(status().isOk());

  }
}
