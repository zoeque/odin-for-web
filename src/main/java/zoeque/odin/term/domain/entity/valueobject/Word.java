package zoeque.odin.term.domain.entity.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The value object embedded in {@link zoeque.odin.term.domain.entity.Term}.
 */
@Embeddable
@Getter
@NoArgsConstructor
public class Word {
  @Column(name = "word_phrase")
  String phrase;

  public Word(String phrase) {
    setPhrase(phrase);
  }

  private void setPhrase(String phrase) {
    if (phrase == null) {
      throw new IllegalArgumentException("Word must contains its name");
    }
    this.phrase = phrase;
  }
}
