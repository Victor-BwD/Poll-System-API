package br.com.victorbwd.infrastructure.persistence.mapper;

import br.com.victorbwd.domain.entity.Option;
import br.com.victorbwd.infrastructure.persistence.document.OptionDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionMapper {

    Option toDomain(OptionDocument document);

    OptionDocument toDocument(Option domain);
}
