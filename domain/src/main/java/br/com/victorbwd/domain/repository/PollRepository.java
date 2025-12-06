package br.com.victorbwd.domain.repository;

import br.com.victorbwd.domain.entity.Poll;

import java.util.Optional;

public interface PollRepository {
    Poll save(Poll poll);

    Optional<Poll> findById(String id);
}
