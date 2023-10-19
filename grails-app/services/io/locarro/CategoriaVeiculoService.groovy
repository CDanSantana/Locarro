package io.locarro

import grails.gorm.services.Service

@Service(CategoriaVeiculo)
interface CategoriaVeiculoService {

    CategoriaVeiculo get(Serializable id)

    List<CategoriaVeiculo> list(Map args)

    Long count()

    void delete(Serializable id)

    CategoriaVeiculo save(CategoriaVeiculo categoriaVeiculo)

}