package io.locarro

class StatusReserva {
    String nome
    String descricao

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
    }
}
