package br.com.fiap.ra_rm99996.service;

import br.com.fiap.ra_rm99996.dto.AbrigoDTO;
import br.com.fiap.ra_rm99996.entity.Abrigo;
import br.com.fiap.ra_rm99996.repository.AbrigoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    private final AbrigoRepository repository;

    public AbrigoService(AbrigoRepository repository) {
        this.repository = repository;
    }

    public Abrigo criar(AbrigoDTO dto) {
        Abrigo a = new Abrigo();
        a.setNome(dto.nome);
        a.setEndereco(dto.endereco);
        a.setCapacidade(dto.capacidade);
        a.setTelefone(dto.telefone);
        a.setResponsavel(dto.responsavel);
        return repository.save(a);
    }

    public Abrigo atualizar(Long id, AbrigoDTO dto) {
        Abrigo a = repository.findById(id).orElseThrow();
        a.setNome(dto.nome);
        a.setEndereco(dto.endereco);
        a.setCapacidade(dto.capacidade);
        a.setTelefone(dto.telefone);
        a.setResponsavel(dto.responsavel);
        return repository.save(a);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Abrigo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Abrigo> listarTodos() {
        return repository.findAll();
    }
}
