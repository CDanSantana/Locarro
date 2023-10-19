package io.locarro

import grails.gorm.services.Service

@Service(Formacao)
interface FormacaoService {

    Formacao get(Serializable id)

    List<Formacao> list(Map args)

    Long count()

    void delete(Serializable id)

    Formacao save(Formacao formacao)

}