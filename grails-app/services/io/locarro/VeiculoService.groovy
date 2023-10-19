package io.locarro

import grails.gorm.services.Service

@Service(Veiculo)
interface VeiculoService {

    Veiculo get(Serializable id)

    List<Veiculo> list(Map args)

    Long count()

    void delete(Serializable id)

    Veiculo save(Veiculo veiculo)

}