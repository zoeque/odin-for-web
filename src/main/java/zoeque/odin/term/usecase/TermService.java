package zoeque.odin.term.usecase;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zoeque.odin.term.domain.entity.Term;
import zoeque.odin.term.domain.factory.TermFactory;
import zoeque.odin.term.domain.repository.TermRepository;
import zoeque.odin.term.dto.TermDto;

/**
 * The service class to handle {@link Term}.
 */
@Slf4j
@Service
public class TermService {
  TermRepository repository;
  TermFactory factory;

  /**
   * Create {@link Term} entity and save it in DB.
   *
   * @param dto The full set of fields.
   * @return The instance with the created DTO.
   */
  public Try<TermDto> create(TermDto dto) {
    try {
      Term term = factory.create(dto.word().phrase(),
              dto.meaning().phrase()).get();
      repository.save(term);
      return Try.success(dto);
    } catch (Exception e) {
      return Try.failure(e);
    }
  }
}
