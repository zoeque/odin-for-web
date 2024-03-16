package zoeque.odin.term.domain.entity.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The value object contains the meaning of the word embedded in
 * {@link zoeque.odin.term.domain.entity.Term}.
 */
@Embeddable
@Getter
@NoArgsConstructor
public class Meaning {
  @Column(name = "meaning_phrase")
  String phrase;

  public Meaning(String phrase) {
    setPhrase(phrase);
  }

  public void setPhrase(String phrase) {
    if (phrase == null) {
      throw new IllegalArgumentException("Word must have its meaning");
    }
    this.phrase = phrase;
  }
}
