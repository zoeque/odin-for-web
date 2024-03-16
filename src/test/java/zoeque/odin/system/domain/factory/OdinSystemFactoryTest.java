package zoeque.odin.system.domain.factory;

import io.vavr.control.Try;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoeque.odin.system.domain.entity.OdinSystem;
import zoeque.odin.system.domain.factory.OdinSystemFactory;
import zoeque.odin.system.domain.repository.OdinSystemRepository;
import zoeque.odin.tool.DatabaseDropService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OdinSystemFactoryTest {
  @Autowired
  OdinSystemFactory factory;
  @Autowired
  OdinSystemRepository repository;
  @Autowired
  DatabaseDropService dropService;

  @BeforeEach
  public void cleanAllDataInDb() {
    dropService.deleteAll();
  }

  @Test
  public void whenSystemDoesNotExistInDb_createNewInstance() {
    Try<OdinSystem> odinSystems = factory.create(false, false, 3, 0);
    Assertions.assertTrue(odinSystems.isSuccess());
  }

  @Test
  public void whenSystemExistsInDb_doesNotCreateNewInstance() {
    repository.save(new OdinSystem(false, false, 3, 0));
    Try<OdinSystem> odinSystems = factory.create(false, false, 3, 0);
    Assertions.assertTrue(odinSystems.isFailure());
  }
}
