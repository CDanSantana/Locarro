package io.locarro

import grails.gorm.services.Service

@Service(TipoTelefone)
interface TipoTelefoneService {

    TipoTelefone get(Serializable id)

    List<TipoTelefone> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoTelefone save(TipoTelefone tipoTelefone)

}