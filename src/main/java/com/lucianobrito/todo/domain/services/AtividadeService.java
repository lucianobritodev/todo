package com.lucianobrito.todo.domain.services;

import com.lucianobrito.todo.domain.entities.Atividade;
import com.lucianobrito.todo.domain.repositories.AtividadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AtividadeService {

    private AtividadeRepository atividadeRepository;

    @Transactional(readOnly = true)
    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Atividade findAOneById(Long id) {
        return atividadeRepository.findById(id).orElse(new Atividade());
    }

    @Transactional
    public void deleteById(Long id) {
        Atividade atividadeDb = findAOneById(id);
        if (atividadeDb.getId() != null)
            atividadeRepository.deleteById(id);
    }

    @Transactional
    public Atividade create(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    @Transactional
    public Atividade update(Long id, Atividade atividade) {
        Atividade atividadeDb = findAOneById(id);
        if(atividadeDb.getId() != null) {
            atividade.setId(id);
            return atividadeRepository.save(atividade);
        }

        return new Atividade();
    }
}

