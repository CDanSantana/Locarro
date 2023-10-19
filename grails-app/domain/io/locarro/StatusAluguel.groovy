package io.locarro

class StatusAluguel {
    String nome
    String descricao

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
    }
}
