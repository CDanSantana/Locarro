package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CidadeServiceSpec extends Specification {

    CidadeService cidadeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Cidade(...).save(flush: true, failOnError: true)
        //new Cidade(...).save(flush: true, failOnError: true)
        //Cidade cidade = new Cidade(...).save(flush: true, failOnError: true)
        //new Cidade(...).save(flush: true, failOnError: true)
        //new Cidade(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cidade.id
    }

    void "test get"() {
        setupData()

        expect:
        cidadeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Cidade> cidadeList = cidadeService.list(max: 2, offset: 2)

        then:
        cidadeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cidadeService.count() == 5
    }

    void "test delete"() {
        Long cidadeId = setupData()

        expect:
        cidadeService.count() == 5

        when:
        cidadeService.delete(cidadeId)
        sessionFactory.currentSession.flush()

        then:
        cidadeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Cidade cidade = new Cidade()
        cidadeService.save(cidade)

        then:
        cidade.id != null
    }
}
