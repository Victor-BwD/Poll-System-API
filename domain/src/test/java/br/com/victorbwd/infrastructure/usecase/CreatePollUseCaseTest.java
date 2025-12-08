package br.com.victorbwd.infrastructure.usecase;

import br.com.victorbwd.domain.repository.PollRepository;
import br.com.victorbwd.domain.usecases.CreatePollUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreatePollUseCaseTest {
    private CreatePollUseCase createPollUseCase;

    @Mock
    private PollRepository pollRepositoryMock;

    @BeforeEach
    void setUp() {
        createPollUseCase = new CreatePollUseCase(pollRepositoryMock);
    }

    @Test
    @DisplayName("Deve criar uma enquete com sucesso quando os dados forem válidos")
    void shouldCreatePollSuccessfully_whenDataIsValid() {

        var input = new CreatePollUseCase.Input(
                "Qual sua linguagem de programação favorita?",
                List.of("Java", "Python", "JavaScript"),
                120L
        );

        Mockito.when(pollRepositoryMock.save(Mockito.any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var createdPoll = createPollUseCase.execute(input);

        Assertions.assertNotNull(createdPoll);
        Assertions.assertNotNull(createdPoll.getId());
        Assertions.assertEquals("Qual sua linguagem de programação favorita?", createdPoll.getTitle());
        Assertions.assertEquals(input.title(), createdPoll.getTitle());
        Assertions.assertEquals(3, createdPoll.getOptions().size());
        Assertions.assertNotNull(createdPoll.getCreatedAt());
        Assertions.assertNotNull(createdPoll.getExpiresAt());

        Mockito.verify(pollRepositoryMock, org.mockito.Mockito.times(1)).save(org.mockito.ArgumentMatchers.any());
    }


}
