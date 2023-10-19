package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StatusVeiculoServiceSpec extends Specification {

    StatusVeiculoService statusVeiculoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new StatusVeiculo(...).save(flush: true, failOnError: true)
        //new StatusVeiculo(...).save(flush: true, failOnError: true)
        //StatusVeiculo statusVeiculo = new StatusVeiculo(...).save(flush: true, failOnError: true)
        //new StatusVeiculo(...).save(flush: true, failOnError: true)
        //new StatusVeiculo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //statusVeiculo.id
    }

    void "test get"() {
        setupData()

        expect:
        statusVeiculoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<StatusVeiculo> statusVeiculoList = statusVeiculoService.list(max: 2, offset: 2)

        then:
        statusVeiculoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        statusVeiculoService.count() == 5
    }

    void "test delete"() {
        Long statusVeiculoId = setupData()

        expect:
        statusVeiculoService.count() == 5

        when:
        statusVeiculoService.delete(statusVeiculoId)
        sessionFactory.currentSession.flush()

        then:
        statusVeiculoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        StatusVeiculo statusVeiculo = new StatusVeiculo()
        statusVeiculoService.save(statusVeiculo)

        then:
        statusVeiculo.id != null
    }
}
