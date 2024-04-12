package zoeque.odin.term.dto.valueobject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import zoeque.odin.term.dto.TermDto;

/**
 * The DTO class include the phrase of the meaning of {@link zoeque.odin.term.domain.entity.Term}
 *
 * @param phrase
 */
@JsonDeserialize(as = MeaningDto.class)
public record MeaningDto(String phrase) {
}
