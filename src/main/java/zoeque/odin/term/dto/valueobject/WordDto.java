package zoeque.odin.term.dto.valueobject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import zoeque.odin.term.dto.TermDto;

/**
 * The dto class to contains the phrase of the word.
 */
@JsonDeserialize(as = WordDto.class)
public record WordDto(String phrase) {
}
