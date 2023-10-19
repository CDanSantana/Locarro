package io.locarro

class Reserva {
    Date dataInicioReserva
    Date dataFimReserva
    Veiculo veiculoReservado
    Pessoa pessoaCliente
    StatusReserva statusReserva

    static constraints = {
        dataInicioReserva(nullable: false, blank: false)
        dataFimReserva(nullable: false, blank: false)
        veiculoReservado(nullable: false, blank: false)
        pessoaCliente(nullable: false, blank: false)
        statusReserva(nullable: false, blank: false)
    }
}
