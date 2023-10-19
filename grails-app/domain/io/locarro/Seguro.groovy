package io.locarro

class Seguro {
    String numeroApolice
    BigDecimal valorCobertura
    Date dataExpiracao
    String seguradora
    String descricao

    static belongsTo = [veiculo: Veiculo]

    static constraints = {
        numeroApolice(nullable: false, blank: false)
        valorCobertura(nullable: false, blank: false)
        dataExpiracao(nullable: false, blank: false)
        veiculo(nullable: false, blank: false)
        seguradora(nullable: false, blank: false)
        descricao(nullable: false, blank: false)
    }
}
