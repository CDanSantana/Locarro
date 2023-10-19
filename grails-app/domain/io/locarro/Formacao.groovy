package io.locarro

class Formacao {
    String nome

    static constraints = {
        nome(nullable: false, blank: false, size: 1..100)
    }

    String toString() {
        nome
    }

}
