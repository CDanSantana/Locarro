package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MetodoPagamentoServiceSpec extends Specification {

    MetodoPagamentoService metodoPagamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MetodoPagamento(...).save(flush: true, failOnError: true)
        //new MetodoPagamento(...).save(flush: true, failOnError: true)
        //MetodoPagamento metodoPagamento = new MetodoPagamento(...).save(flush: true, failOnError: true)
        //new MetodoPagamento(...).save(flush: true, failOnError: true)
        //new MetodoPagamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //metodoPagamento.id
    }

    void "test get"() {
        setupData()

        expect:
        metodoPagamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MetodoPagamento> metodoPagamentoList = metodoPagamentoService.list(max: 2, offset: 2)

        then:
        metodoPagamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        metodoPagamentoService.count() == 5
    }

    void "test delete"() {
        Long metodoPagamentoId = setupData()

        expect:
        metodoPagamentoService.count() == 5

        when:
        metodoPagamentoService.delete(metodoPagamentoId)
        sessionFactory.currentSession.flush()

        then:
        metodoPagamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MetodoPagamento metodoPagamento = new MetodoPagamento()
        metodoPagamentoService.save(metodoPagamento)

        then:
        metodoPagamento.id != null
    }
}
