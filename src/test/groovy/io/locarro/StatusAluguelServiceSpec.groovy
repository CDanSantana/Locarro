package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StatusAluguelServiceSpec extends Specification {

    StatusAluguelService statusAluguelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new StatusAluguel(...).save(flush: true, failOnError: true)
        //new StatusAluguel(...).save(flush: true, failOnError: true)
        //StatusAluguel statusAluguel = new StatusAluguel(...).save(flush: true, failOnError: true)
        //new StatusAluguel(...).save(flush: true, failOnError: true)
        //new StatusAluguel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //statusAluguel.id
    }

    void "test get"() {
        setupData()

        expect:
        statusAluguelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<StatusAluguel> statusAluguelList = statusAluguelService.list(max: 2, offset: 2)

        then:
        statusAluguelList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        statusAluguelService.count() == 5
    }

    void "test delete"() {
        Long statusAluguelId = setupData()

        expect:
        statusAluguelService.count() == 5

        when:
        statusAluguelService.delete(statusAluguelId)
        sessionFactory.currentSession.flush()

        then:
        statusAluguelService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        StatusAluguel statusAluguel = new StatusAluguel()
        statusAluguelService.save(statusAluguel)

        then:
        statusAluguel.id != null
    }
}
