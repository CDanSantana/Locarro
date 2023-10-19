package io.locarro

class Manutencao {
    Date dataManutencao
    TipoManutencao tipoManutencao
    String descricao

    static belongsTo = [veiculo: Veiculo]

    static constraints = {
        dataManutencao(nullable: false, blank: false)
        veiculo(nullable: false, blank: false)
        tipoManutencao(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
    }
}
