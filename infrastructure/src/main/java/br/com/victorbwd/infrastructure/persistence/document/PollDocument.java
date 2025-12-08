package br.com.victorbwd.infrastructure.persistence.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "polls")
public class PollDocument {
    @Id
    private String id;
    private String title;
    private String createdAt;
    private String expiresAt;
    private List<OptionDocument> options;
}
