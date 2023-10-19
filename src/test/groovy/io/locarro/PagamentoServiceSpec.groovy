package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PagamentoServiceSpec extends Specification {

    PagamentoService pagamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pagamento(...).save(flush: true, failOnError: true)
        //new Pagamento(...).save(flush: true, failOnError: true)
        //Pagamento pagamento = new Pagamento(...).save(flush: true, failOnError: true)
        //new Pagamento(...).save(flush: true, failOnError: true)
        //new Pagamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pagamento.id
    }

    void "test get"() {
        setupData()

        expect:
        pagamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pagamento> pagamentoList = pagamentoService.list(max: 2, offset: 2)

        then:
        pagamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pagamentoService.count() == 5
    }

    void "test delete"() {
        Long pagamentoId = setupData()

        expect:
        pagamentoService.count() == 5

        when:
        pagamentoService.delete(pagamentoId)
        sessionFactory.currentSession.flush()

        then:
        pagamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pagamento pagamento = new Pagamento()
        pagamentoService.save(pagamento)

        then:
        pagamento.id != null
    }
}
