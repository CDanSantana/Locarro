package io.locarro

class StatusVeiculo {
    String nome
    String descricao

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
    }
}
