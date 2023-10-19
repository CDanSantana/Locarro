package io.locarro

import grails.gorm.services.Service

@Service(TipoEndereco)
interface TipoEnderecoService {

    TipoEndereco get(Serializable id)

    List<TipoEndereco> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoEndereco save(TipoEndereco tipoEndereco)

}