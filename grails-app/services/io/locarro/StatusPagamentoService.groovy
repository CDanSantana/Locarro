package io.locarro

import grails.gorm.services.Service

@Service(StatusPagamento)
interface StatusPagamentoService {

    StatusPagamento get(Serializable id)

    List<StatusPagamento> list(Map args)

    Long count()

    void delete(Serializable id)

    StatusPagamento save(StatusPagamento statusPagamento)

}