package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AluguelServiceSpec extends Specification {

    AluguelService aluguelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Aluguel(...).save(flush: true, failOnError: true)
        //new Aluguel(...).save(flush: true, failOnError: true)
        //Aluguel aluguel = new Aluguel(...).save(flush: true, failOnError: true)
        //new Aluguel(...).save(flush: true, failOnError: true)
        //new Aluguel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //aluguel.id
    }

    void "test get"() {
        setupData()

        expect:
        aluguelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Aluguel> aluguelList = aluguelService.list(max: 2, offset: 2)

        then:
        aluguelList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        aluguelService.count() == 5
    }

    void "test delete"() {
        Long aluguelId = setupData()

        expect:
        aluguelService.count() == 5

        when:
        aluguelService.delete(aluguelId)
        sessionFactory.currentSession.flush()

        then:
        aluguelService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Aluguel aluguel = new Aluguel()
        aluguelService.save(aluguel)

        then:
        aluguel.id != null
    }
}
