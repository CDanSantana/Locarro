package io.locarro

class Pagamento {
    BigDecimal valor
    MetodoPagamento metodoPagamento
    StatusPagamento statusPagamento
    Aluguel aluguelRelacionado

    static constraints = {
        valor(nullable: false, blank: false)
        metodoPagamento(nullable: false, blank: false)
        statusPagamento(nullable: false, blank: false)
        aluguelRelacionado(nullable: false, blank: false)
    }
}
