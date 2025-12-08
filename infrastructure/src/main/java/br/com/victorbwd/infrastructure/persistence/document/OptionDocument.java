package br.com.victorbwd.infrastructure.persistence.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "options")
public class OptionDocument {
    private String id;
    private String title;
}
