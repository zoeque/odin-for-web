package zoeque.odin.term.domain.entity.valueobject;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Meaning {
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
