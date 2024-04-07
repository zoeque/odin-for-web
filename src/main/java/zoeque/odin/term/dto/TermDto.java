package zoeque.odin.term.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import zoeque.odin.term.domain.entity.valueobject.MemorizedState;
import zoeque.odin.term.dto.valueobject.MeaningDto;
import zoeque.odin.term.dto.valueobject.WordDto;

/**
 * The dto class to contain necessary fields.
 */
@JsonDeserialize(as = TermDto.class)
public record TermDto(WordDto word,
                      MeaningDto meaning,
                      MemorizedState state) {
}
