package zoeque.odin.term.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import zoeque.odin.term.domain.entity.Term;
import zoeque.odin.term.domain.entity.valueobject.MemorizedState;
import zoeque.odin.term.domain.repository.TermRepository;
import zoeque.odin.term.dto.TermDto;
import zoeque.odin.term.dto.valueobject.MeaningDto;
import zoeque.odin.term.dto.valueobject.WordDto;
import zoeque.odin.term.usecase.TermService;
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

  @Autowired
  TermService termService;

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

  @Test
  public void sendMockRestRequest_attemptToUpdate_return200() throws Exception {
    TermDto dto = new TermDto(new WordDto("test"), new MeaningDto("test"), MemorizedState.NOT_MEMORIZED);
    Try<TermDto> createTry = termService.create(dto);
    // check the DTO is created on Database
    Assertions.assertTrue(createTry.isSuccess());

    TermDto updatedDto = new TermDto(new WordDto("test"), new MeaningDto("test"), MemorizedState.MEMORIZED);
    String json = mapper.writeValueAsString(updatedDto);

    mvc.perform(post("/term/edit")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
            .andExpect(status().isOk());

    List<Term> all = repository.findAll();
    Assertions.assertEquals(MemorizedState.MEMORIZED, all.get(0).getState());
  }
}
