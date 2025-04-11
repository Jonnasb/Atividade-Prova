package com.example.atividadeSpringApi.service;

import com.example.atividadeSpringApi.model.Funcionario;
import com.example.atividadeSpringApi.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {

    /*A classe FuncionarioService é responsavel pela logica e validação das infomraões tratadas dentro do sistema  */

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios(){ // função lista todos os usuarios já cadastrados no sistema
        return funcionarioRepository.findAll();

    }

    public Funcionario salvar(@Valid Funcionario funcionario){ // função para salvar usuario através do email
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new RuntimeException("Funcionario jÃ¡ cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){ // função responvel por atualizar informações que jã foram cadastradas no sistema
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId()) // feito através da localização o id
                .orElseThrow(()-> new RuntimeException("Funcionario nÃ£o encontrado"));

        funcionarioAtualizar.setNome(funcionario.getNome()); // pegando cadastro atualizado e atualizando as informações novamente
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void  excluir(Long id){ // função para excluir funcionario utilizando id como parametro
        Funcionario usuario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario jÃ¡ excluido ou inexistente "));

        funcionarioRepository.deleteById(usuario.getId());
    }
}
