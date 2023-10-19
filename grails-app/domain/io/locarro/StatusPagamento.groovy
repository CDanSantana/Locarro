package io.locarro

class StatusPagamento {
    String nome
    String descricao
    Boolean ativo

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
        ativo(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
