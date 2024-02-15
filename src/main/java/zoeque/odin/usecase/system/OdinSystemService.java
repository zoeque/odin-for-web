package zoeque.odin.usecase.system;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import zoeque.odin.domain.system.entity.OdinSystem;
import zoeque.odin.domain.system.factory.OdinSystemFactory;
import zoeque.odin.domain.system.repository.OdinSystemRepository;

/**
 * The usecase class to create or edit the system option.
 */
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
      OdinSystem odinSystem = factory.create(false, false, 3).get();
      repository.save(odinSystem);
      return Try.success(odinSystem);
    } catch (Exception e) {
      return Try.failure(e);
    }
  }
}
