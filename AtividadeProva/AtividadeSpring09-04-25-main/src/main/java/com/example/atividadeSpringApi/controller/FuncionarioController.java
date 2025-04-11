package com.example.atividadeSpringApi.controller;

import com.example.atividadeSpringApi.model.Funcionario;
import com.example.atividadeSpringApi.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // Uma marcação que responde a requisição do HTTP.
@RequestMapping("/funcionario") // Diz a ou rota base da sua controller.
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping  // Função de Requisição do JSON que manda lista
    public List<Funcionario> listartodos(){
        return funcionarioService.listarFuncionarios();
    }


    @PostMapping // Função recebe requisição do JSON e envia para o service e salva todos os dados cadastrados
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem","Funcionario cadastrado com sucesso"));

    }


    @PutMapping // função recebe requisição do JSON e envia para o service os novos dados e atuliza os usuarios cadastrados
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados cadastrais atualidos "));
    }


    @DeleteMapping("/{id}") // função recebe requisição do JSON e envia para o service o id do usuario a ser excluido
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Funcionario deletado com sucesso"));

    }
}
