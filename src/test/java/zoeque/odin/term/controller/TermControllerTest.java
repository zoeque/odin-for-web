package zoeque.odin.term.controller;

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
import zoeque.odin.term.domain.entity.valueobject.MemorizedState;
import zoeque.odin.term.domain.repository.TermRepository;
import zoeque.odin.term.dto.TermDto;
import zoeque.odin.term.dto.valueobject.MeaningDto;
import zoeque.odin.term.dto.valueobject.WordDto;
import zoeque.odin.tool.DatabaseDropService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TermControllerTest {
  private MockMvc mvc;
  @Autowired
  DatabaseDropService dropService;
  @Autowired
  ObjectMapper mapper;
  @Autowired
  TermController controller;
  @Autowired
  TermRepository repository;

  @BeforeEach
  public void cleanup() {
    dropService.deleteAll();
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void sendMockRestRequest_attemptToCreate_return200() throws Exception {
    TermDto dto = new TermDto(new WordDto("test"), new MeaningDto("test"), MemorizedState.NOT_MEMORIZED);
    String json = mapper.writeValueAsString(dto);

    mvc.perform(post("/term/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
            .andExpect(status().isOk());
  }
}
