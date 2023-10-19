package io.locarro

class MetodoPagamento {
    String nome

    static constraints = {
        nome(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
