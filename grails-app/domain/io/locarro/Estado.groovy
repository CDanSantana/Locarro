package io.locarro

class Estado {
    String nome
    String sigla

    static hasMany = [cidades: Cidade]

    static constraints = {
        nome(nullable: false, blank: false, size: 1..255)
        sigla(nullable: false, blank: false, size: 1..2)
        cidades(nullable: true, blank: true)
    }

    String toString() {
        sigla+' - '+nome
    }

}
