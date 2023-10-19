package io.locarro

class Telefone {
    String ddd
    String numero
    TipoTelefone tipoTelefone

    static constraints = {
        ddd(nullable: false, blank: false, size: 1..3, matches: "[0-9]{1,}")
        numero(nullable: false, blank: false, size: 8..12, matches: "[0-9]{8,}")
        tipoTelefone(nullable: false, blank: false)
    }

}
