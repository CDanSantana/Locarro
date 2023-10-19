package io.locarro

import grails.gorm.services.Service

@Service(Manutencao)
interface ManutencaoService {

    Manutencao get(Serializable id)

    List<Manutencao> list(Map args)

    Long count()

    void delete(Serializable id)

    Manutencao save(Manutencao manutencao)

}