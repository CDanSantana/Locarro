package io.locarro

class TipoManutencao {
    String nome

    static constraints = {
        nome(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
