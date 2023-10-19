package io.locarro

class Veiculo {
    String modelo
    String fabricante
    String placa
    Integer ano

    static hasMany = [extras: Extra]

    static constraints = {
        ano(nullable: false, blank: false)
        extras(nullable: true, blank: true)
        modelo(nullable: false, blank: false)
        fabricante(nullable: false, blank: false)
        placa(unique: ['ano'], nullable: false, blank: false, size: 7..7)
    }

    String toString() {
         placa + " | " + fabricante + " " + modelo + " " + ano.toString()
    }

}