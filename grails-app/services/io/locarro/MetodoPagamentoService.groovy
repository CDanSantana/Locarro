package io.locarro

import grails.gorm.services.Service

@Service(MetodoPagamento)
interface MetodoPagamentoService {

    MetodoPagamento get(Serializable id)

    List<MetodoPagamento> list(Map args)

    Long count()

    void delete(Serializable id)

    MetodoPagamento save(MetodoPagamento metodoPagamento)

}