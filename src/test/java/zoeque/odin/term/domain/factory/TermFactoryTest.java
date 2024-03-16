package zoeque.odin.term.domain.factory;

import io.vavr.control.Try;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoeque.odin.term.domain.entity.Term;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TermFactoryTest {
  @Autowired
  TermFactory factory;

  @Test
  public void givenAllFields_attemptToCreate_returnInstance() {
    Try<Term> createTry = factory.create("test", "test");
    Assertions.assertTrue(createTry.isSuccess());
  }

  @Test
  public void givenFieldsWithRack_attemptToCreate_returnFailure() {
    Try<Term> createTry = factory.create(null, null);
    Assertions.assertTrue(createTry.isFailure());
  }
}
