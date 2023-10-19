package io.locarro

import grails.gorm.services.Service

@Service(Telefone)
interface TelefoneService {

    Telefone get(Serializable id)

    List<Telefone> list(Map args)

    Long count()

    void delete(Serializable id)

    Telefone save(Telefone telefone)

}