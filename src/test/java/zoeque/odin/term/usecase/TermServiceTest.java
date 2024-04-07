package zoeque.odin.term.usecase;

import io.vavr.control.Try;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoeque.odin.term.domain.entity.Term;
import zoeque.odin.term.domain.repository.TermRepository;
import zoeque.odin.term.dto.TermDto;
import zoeque.odin.term.dto.valueobject.MeaningDto;
import zoeque.odin.term.dto.valueobject.WordDto;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TermServiceTest {
  @Autowired
  TermService service;
  @Autowired
  TermRepository repository;

  @BeforeEach
  void clean() {
    repository.deleteAll();
  }

  @Test
  public void givenDto_whenSave_thenCreatedInDb() {
    TermDto termDto = new TermDto(new WordDto("test"), new MeaningDto("test"));
    Try<TermDto> createTry = service.create(termDto);

    List<Term> all = repository.findAll();
    Assertions.assertTrue(createTry.isSuccess());
    Assertions.assertEquals(1, all.size());
  }

  @Test
  public void givenDto_whenDelete_thenNoDataInDb() {
    TermDto termDto = new TermDto(new WordDto("test"), new MeaningDto("test"));
    Try<TermDto> createTry = service.create(termDto);
    Assertions.assertTrue(createTry.isSuccess());
    List<Term> allBefore = repository.findAll();
    Assertions.assertEquals(1, allBefore.size());

    Try<TermDto> deleteTry = service.delete(termDto);
    List<Term> allAfter = repository.findAll();
    Assertions.assertTrue(deleteTry.isSuccess());
    Assertions.assertEquals(0, allAfter.size());

  }
}
