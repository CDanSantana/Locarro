package io.locarro

class TipoTelefone {
    String nome

    static constraints = {
        nome(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
