package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FormacaoServiceSpec extends Specification {

    FormacaoService formacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Formacao(...).save(flush: true, failOnError: true)
        //new Formacao(...).save(flush: true, failOnError: true)
        //Formacao formacao = new Formacao(...).save(flush: true, failOnError: true)
        //new Formacao(...).save(flush: true, failOnError: true)
        //new Formacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //formacao.id
    }

    void "test get"() {
        setupData()

        expect:
        formacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Formacao> formacaoList = formacaoService.list(max: 2, offset: 2)

        then:
        formacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        formacaoService.count() == 5
    }

    void "test delete"() {
        Long formacaoId = setupData()

        expect:
        formacaoService.count() == 5

        when:
        formacaoService.delete(formacaoId)
        sessionFactory.currentSession.flush()

        then:
        formacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Formacao formacao = new Formacao()
        formacaoService.save(formacao)

        then:
        formacao.id != null
    }
}
