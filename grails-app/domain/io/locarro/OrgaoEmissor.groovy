package io.locarro

class OrgaoEmissor {
    String nome
    String sigla
    Estado estado

    static constraints = {
        nome(nullable: false, blank: false, size: 1..255)
        sigla(nullable: false, blank: false, size: 1..20)
        estado(nullable: false, blank: false)
    }

    String toString() {
        sigla+'-'+estado.sigla
    }

}
