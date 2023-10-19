package io.locarro

import grails.gorm.services.Service

@Service(Aluguel)
interface AluguelService {

    Aluguel get(Serializable id)

    List<Aluguel> list(Map args)

    Long count()

    void delete(Serializable id)

    Aluguel save(Aluguel aluguel)

}