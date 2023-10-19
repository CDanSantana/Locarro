package io.locarro

class Extra {
    String nome
    String valor

    static constraints = {
        nome(nullable: false, blank: false)
        valor(nullable: false, blank: false)
    }

    String toString() {
        nome + ": " + valor
    }

}
