package io.locarro

class Aluguel {
    Date dataInicioAluguel
    Date dataFimAluguel
    Veiculo veiculoAlugado
    Pessoa pessoaCliente
    BigDecimal custoTotal
    StatusAluguel statusAluguel

    static constraints = {
        dataInicioAluguel(nullable: false, blank: false)
        dataFimAluguel(nullable: false, blank: false)
        veiculoAlugado(nullable: false, blank: false)
        pessoaCliente(nullable: false, blank: false)
        custoTotal(nullable: false, blank: false)
        statusAluguel(nullable: false, blank: false)
    }
}
