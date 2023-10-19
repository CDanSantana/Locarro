package io.locarro

import grails.gorm.services.Service

@Service(StatusReserva)
interface StatusReservaService {

    StatusReserva get(Serializable id)

    List<StatusReserva> list(Map args)

    Long count()

    void delete(Serializable id)

    StatusReserva save(StatusReserva statusReserva)

}