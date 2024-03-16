package zoeque.odin.term.domain.factory;

import io.vavr.control.Try;
import org.springframework.stereotype.Component;
import zoeque.odin.term.domain.entity.Term;
import zoeque.odin.term.domain.entity.valueobject.Meaning;
import zoeque.odin.term.domain.entity.valueobject.Word;

/**
 * The factory class to create new {@link Term}.
 */
@Component
public class TermFactory {
  public Try<Term> create(String wordPhrase,
                          String meaningPhrase) {
    try {
      return Try.success(new Term(createWord(wordPhrase).get(),
              createMeaning(meaningPhrase).get()));
    } catch (Exception e) {
      return Try.failure(e);
    }
  }

  private Try<Word> createWord(String wordPhrase) {
    return Try.success(new Word(wordPhrase));
  }

  private Try<Meaning> createMeaning(String meaningPhrase) {
    return Try.success(new Meaning(meaningPhrase));
  }
}
