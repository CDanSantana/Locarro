package io.locarro

import grails.gorm.services.Service

@Service(Pagamento)
interface PagamentoService {

    Pagamento get(Serializable id)

    List<Pagamento> list(Map args)

    Long count()

    void delete(Serializable id)

    Pagamento save(Pagamento pagamento)

}