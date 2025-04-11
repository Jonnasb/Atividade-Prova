package com.example.atividadeSpringApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
/*A classe FUncionario é resposanvel pelos atributos da classe */
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private Setor setor;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotBlank(message = "Informe o nome do funcionario.") // @NotBlank  impede que o campo não fique sem ser preechido.
    private String nome;

    @NotBlank(message = "Digite da data de Aniversário do Funcionario.")
    private String dataNascimento;

    @NotBlank(message = "Digite seu CPF.")
    @Size(min = 11, max = 11, message = "O CPF precisa ter o numero valido de digitos ") //@Size
    private String cpf;

    @NotBlank(message = "O emial é Obrigatorio")
    @Email(message = "Informe um E-mail valido") // @Email valida um email no momnento de cadastro
    private String email;

    @NotNull(message = "o campo SALARIO é obrigatorio") // NotNull evita que o campo fique vazio para double int e afins
    @PositiveOrZero(message = "O campo não po ser negativo")//@PositiveOrZero evita que o campo salario fique negativo
    private double salario;

    public Funcionario() {
    }

    public Funcionario(Long id, Sexo sexo, Setor setor, EstadoCivil estadoCivil, Endereco endereco, String nome, String dataNascimento, String cpf, String email, double salario) {
        this.id = id;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", sexo=" + sexo +
                ", setor=" + setor +
                ", estadoCivil=" + estadoCivil +
                ", endereco=" + endereco +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                '}';
    }
}
