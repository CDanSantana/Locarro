package io.locarro

import grails.gorm.services.Service

@Service(TipoManutencao)
interface TipoManutencaoService {

    TipoManutencao get(Serializable id)

    List<TipoManutencao> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoManutencao save(TipoManutencao tipoManutencao)

}