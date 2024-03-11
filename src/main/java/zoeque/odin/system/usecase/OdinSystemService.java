package zoeque.odin.system.usecase;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zoeque.odin.system.domain.entity.OdinSystem;
import zoeque.odin.system.domain.factory.OdinSystemFactory;
import zoeque.odin.system.domain.repository.OdinSystemRepository;
import zoeque.odin.system.dto.OdinSystemDto;

/**
 * The usecase class to create or edit the system option.
 */
@Slf4j
@Service
public class OdinSystemService {
  OdinSystemFactory factory;
  OdinSystemRepository repository;

  public OdinSystemService(OdinSystemFactory factory,
                           OdinSystemRepository repository) {
    this.factory = factory;
    this.repository = repository;
  }

  /**
   * Create and save new odin system in DB.
   *
   * @return Created {@link OdinSystem} with the result Try.
   */
  public Try<OdinSystem> create() {
    try {
      OdinSystem odinSystem = factory.create(false, false, 3, 0).get();
      repository.save(odinSystem);
      return Try.success(odinSystem);
    } catch (Exception e) {
      return Try.failure(e);
    }
  }

  public Try<OdinSystem> edit(OdinSystemDto dto) {
    try {
      OdinSystem odinSystem = repository.findAll().get(0);
      if (odinSystem == null) {
        throw new IllegalStateException("Odin system does not exist in db");
      }

      Try<OdinSystem> editedSystem = odinSystem.edit(
              dto.getRandomFlag(),
              dto.getMemorizedFlag(),
              dto.getListSize(),
              dto.getListIndex()
      );
      return Try.success(editedSystem.get());
    } catch (Exception e) {
      log.warn("Cannot update the system option");
      return Try.failure(e);
    }
  }

}
