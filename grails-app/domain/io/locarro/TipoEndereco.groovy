package io.locarro

class TipoEndereco {
    String nome

    static constraints = {
        nome(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
