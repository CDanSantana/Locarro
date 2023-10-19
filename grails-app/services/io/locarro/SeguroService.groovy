package io.locarro

import grails.gorm.services.Service

@Service(Seguro)
interface SeguroService {

    Seguro get(Serializable id)

    List<Seguro> list(Map args)

    Long count()

    void delete(Serializable id)

    Seguro save(Seguro seguro)

}