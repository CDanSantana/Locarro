package io.locarro

class Historico {
    String acao
    Date horarioRegistro
    String descricao

    static constraints = {
        acao(nullable: false, blank: false)
        horarioRegistro(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
    }
}
