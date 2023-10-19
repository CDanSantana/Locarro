package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VeiculoServiceSpec extends Specification {

    VeiculoService veiculoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Veiculo(...).save(flush: true, failOnError: true)
        //new Veiculo(...).save(flush: true, failOnError: true)
        //Veiculo veiculo = new Veiculo(...).save(flush: true, failOnError: true)
        //new Veiculo(...).save(flush: true, failOnError: true)
        //new Veiculo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //veiculo.id
    }

    void "test get"() {
        setupData()

        expect:
        veiculoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Veiculo> veiculoList = veiculoService.list(max: 2, offset: 2)

        then:
        veiculoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        veiculoService.count() == 5
    }

    void "test delete"() {
        Long veiculoId = setupData()

        expect:
        veiculoService.count() == 5

        when:
        veiculoService.delete(veiculoId)
        sessionFactory.currentSession.flush()

        then:
        veiculoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Veiculo veiculo = new Veiculo()
        veiculoService.save(veiculo)

        then:
        veiculo.id != null
    }
}
