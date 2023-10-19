package io.locarro

import grails.gorm.services.Service

@Service(Sexo)
interface SexoService {

    Sexo get(Serializable id)

    List<Sexo> list(Map args)

    Long count()

    void delete(Serializable id)

    Sexo save(Sexo sexo)

}