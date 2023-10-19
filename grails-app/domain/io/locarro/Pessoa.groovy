package io.locarro

class Pessoa {
    String nome
    String sobrenome
    Integer idade
    Sexo sexo
    String cpf
    String numeroRg
    OrgaoEmissor orgaoEmissor
    Date dataNascimento
    Formacao formacao
    String numeroCnpj
    String email

    static hasMany=[telefones: Telefone, enderecos: Endereco]

    static constraints = {
        nome(nullable: false, blank: false, size: 1..255)
        sobrenome(nullable: false, blank: false, size: 1..255)
        idade(nullable: false, blank: false, min: 18, max: 120)
        sexo(nullable: false, blank: false)
        cpf(nullable: false, blank: false, unique: true, size: 11..14)
        numeroRg(nullable: true, blank: true)
        orgaoEmissor(nullable: true, blank: true)
        dataNascimento(nullable: false, blank: false)
        formacao(nullable: false, blank: false)
        numeroCnpj(nullable: true, blank: true)
        telefones(nullable: false, blank: false)
        enderecos(nullable: false, blank: false)
        email(nullable: true, blank: true, email: true)
    }

}
