package io.locarro

import grails.gorm.services.Service

@Service(StatusVeiculo)
interface StatusVeiculoService {

    StatusVeiculo get(Serializable id)

    List<StatusVeiculo> list(Map args)

    Long count()

    void delete(Serializable id)

    StatusVeiculo save(StatusVeiculo statusVeiculo)

}