package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CategoriaVeiculoServiceSpec extends Specification {

    CategoriaVeiculoService categoriaVeiculoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CategoriaVeiculo(...).save(flush: true, failOnError: true)
        //new CategoriaVeiculo(...).save(flush: true, failOnError: true)
        //CategoriaVeiculo categoriaVeiculo = new CategoriaVeiculo(...).save(flush: true, failOnError: true)
        //new CategoriaVeiculo(...).save(flush: true, failOnError: true)
        //new CategoriaVeiculo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //categoriaVeiculo.id
    }

    void "test get"() {
        setupData()

        expect:
        categoriaVeiculoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CategoriaVeiculo> categoriaVeiculoList = categoriaVeiculoService.list(max: 2, offset: 2)

        then:
        categoriaVeiculoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        categoriaVeiculoService.count() == 5
    }

    void "test delete"() {
        Long categoriaVeiculoId = setupData()

        expect:
        categoriaVeiculoService.count() == 5

        when:
        categoriaVeiculoService.delete(categoriaVeiculoId)
        sessionFactory.currentSession.flush()

        then:
        categoriaVeiculoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CategoriaVeiculo categoriaVeiculo = new CategoriaVeiculo()
        categoriaVeiculoService.save(categoriaVeiculo)

        then:
        categoriaVeiculo.id != null
    }
}
