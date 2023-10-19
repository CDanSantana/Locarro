package io.locarro

class Cidade {
    String nome
    Estado estado

    static constraints = {
        nome(nullable: false, blank: false, size: 1..100)
        estado(nullable: false, blank: false)
    }

    String toString() {
        nome
    }

}
