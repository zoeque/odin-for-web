package zoeque.odin.term.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import zoeque.odin.term.domain.entity.valueobject.Meaning;
import zoeque.odin.term.domain.entity.valueobject.MemorizedState;
import zoeque.odin.term.domain.entity.valueobject.Word;

/**
 * The entity class to contains word attributes
 */
@Entity
@Slf4j
@Getter
@NoArgsConstructor
@Table(name = "term")
public class Term {
  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  long identifier;

  @Embedded
  Word word;
  @Embedded
  Meaning meaning;
  @Enumerated(EnumType.STRING)
  MemorizedState state;

  public Term(Word word,
              Meaning meaning) {
    setWord(word);
    setMeaning(meaning);
    this.state = MemorizedState.NOT_MEMORIZED;
  }

  private void setWord(Word word) {
    if (word == null) {
      throw new IllegalArgumentException("Word must not be null");
    }
    this.word = word;
  }

  private void setMeaning(Meaning meaning) {
    if (meaning == null) {
      throw new IllegalArgumentException("Meaning must not be null");
    }
    this.meaning = meaning;
  }

}
