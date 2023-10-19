package io.locarro

class Sexo {
    String nome
    String sigla

    static constraints = {
        nome(nullable: false, blank: false)
        sigla(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
