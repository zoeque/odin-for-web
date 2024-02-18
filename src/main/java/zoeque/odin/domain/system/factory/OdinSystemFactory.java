package zoeque.odin.domain.system.factory;

import io.vavr.control.Try;
import java.util.List;
import org.springframework.stereotype.Service;
import zoeque.odin.domain.system.entity.OdinSystem;
import zoeque.odin.domain.system.repository.OdinSystemRepository;

/**
 * The factory class to create new
 */
@Service
public class OdinSystemFactory {
  OdinSystemRepository repository;

  public OdinSystemFactory(OdinSystemRepository repository){
    this.repository = repository;
  }
  public Try<OdinSystem> create(Boolean randomFlag,
                                Boolean studiedFlag,
                                Integer listSize,
                                Integer listIndex) {
    try {
      List<OdinSystem> all = repository.findAll();
      if(all.size() > 0){
        throw new IllegalStateException("Setting cannot be saved more than two entities.");
      }
      return Try.success(new OdinSystem(randomFlag, studiedFlag, listSize, listIndex));
    } catch (Exception e) {
      return Try.failure(e);
    }
  }
}
