package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StatusPagamentoServiceSpec extends Specification {

    StatusPagamentoService statusPagamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new StatusPagamento(...).save(flush: true, failOnError: true)
        //new StatusPagamento(...).save(flush: true, failOnError: true)
        //StatusPagamento statusPagamento = new StatusPagamento(...).save(flush: true, failOnError: true)
        //new StatusPagamento(...).save(flush: true, failOnError: true)
        //new StatusPagamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //statusPagamento.id
    }

    void "test get"() {
        setupData()

        expect:
        statusPagamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<StatusPagamento> statusPagamentoList = statusPagamentoService.list(max: 2, offset: 2)

        then:
        statusPagamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        statusPagamentoService.count() == 5
    }

    void "test delete"() {
        Long statusPagamentoId = setupData()

        expect:
        statusPagamentoService.count() == 5

        when:
        statusPagamentoService.delete(statusPagamentoId)
        sessionFactory.currentSession.flush()

        then:
        statusPagamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        StatusPagamento statusPagamento = new StatusPagamento()
        statusPagamentoService.save(statusPagamento)

        then:
        statusPagamento.id != null
    }
}
