package br.com.victorbwd.domain.usecases;

import br.com.victorbwd.domain.entity.Option;
import br.com.victorbwd.domain.entity.Poll;
import br.com.victorbwd.domain.repository.PollRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CreatePollUseCase {
    private final PollRepository pollRepository;

    public record Input(String title, List<String> options, Long durationInMinutes) { }

    public Poll execute(Input input) {
        if(input.title() == null || input.title().isBlank()) {
            throw new IllegalArgumentException("O título da enquete não pode ser nulo ou vazio.");
        }

        if(input.options() == null || input.options().size() < 2) {
            throw new IllegalArgumentException("A enquete deve ter pelo menos duas opções.");
        }

        List<Option> pollOptions = input.options().stream().map(optionsTitle -> Option.builder()
                .id(UUID.randomUUID().toString())
                .title(optionsTitle)
                .build())
                .toList(); // Transforma uma lista de strings em uma lista de opções

        LocalDateTime expiresAt = (input.durationInMinutes != null && input.durationInMinutes() > 0)
                ? LocalDateTime.now().plusMinutes(input.durationInMinutes())
                : LocalDateTime.now().plusMinutes(60); // Duração padrão de 60 minutos

        // Cria a enquete
        Poll pollBulder = Poll.builder().id(UUID.randomUUID().toString())
                .title(input.title())
                .createdAt(LocalDateTime.now())
                .expiresAt(expiresAt)
                .options(pollOptions)
                .build();

        return pollRepository.save(pollBulder);
    }
}
