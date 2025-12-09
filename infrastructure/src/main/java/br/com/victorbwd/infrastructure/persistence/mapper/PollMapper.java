package br.com.victorbwd.infrastructure.persistence.mapper;

import br.com.victorbwd.domain.entity.Poll;
import br.com.victorbwd.infrastructure.persistence.document.PollDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OptionMapper.class})
public interface PollMapper {

    Poll toDomain(PollDocument document);

    PollDocument toDocument(Poll domain);
}
