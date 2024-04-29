package zoeque.odin.system.application;

import io.vavr.control.Try;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import zoeque.odin.system.domain.entity.OdinSystem;
import zoeque.odin.system.domain.repository.OdinSystemRepository;
import zoeque.odin.tool.DatabaseDropService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OdinSystemServiceTest {
  @Autowired
  DatabaseDropService dropService;
  @Autowired
  OdinSystemRepository repository;
  @Autowired
  OdinSystemService service;

  @BeforeEach
  public void cleanAllDataInDb() {
    dropService.deleteAll();
  }

  @Test
  public void attemptCreateNewSystemEntity_returnSuccess() {
    Try<OdinSystem> odinSystems = service.create();
    Assertions.assertTrue(odinSystems.isSuccess());
  }

  @Test
  public void attemptCreateSystem_ifEntityIsAlreadyExist_returnFailure() {
    repository.save(new OdinSystem(false, false, 3, 0));
    Try<OdinSystem> odinSystems = service.create();
    Assertions.assertTrue(odinSystems.isFailure());
  }
}
