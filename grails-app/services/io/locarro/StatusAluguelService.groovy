package io.locarro

import grails.gorm.services.Service

@Service(StatusAluguel)
interface StatusAluguelService {

    StatusAluguel get(Serializable id)

    List<StatusAluguel> list(Map args)

    Long count()

    void delete(Serializable id)

    StatusAluguel save(StatusAluguel statusAluguel)

}