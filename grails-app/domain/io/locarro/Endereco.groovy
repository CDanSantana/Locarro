package io.locarro

class Endereco {
    String rua
    String bairro
    String complemento
    String cep
    Cidade cidade
    String numero
    TipoEndereco tipoEndereco

    static constraints = {
        rua(nullable: false, blank: false, size: 1..150)
        bairro(nullable: false, blank: false, size: 1..150)
        cep(nullable: true, blank: true, matches: "[0-9.-]+")
        complemento(nullable: true, blank: true, size: 1..255)
        cidade(nullable: false, blank: false)
        numero(nullable: false, blank: false, size: 1..10)
        tipoEndereco(nullable: false, blank: false)
    }

}
