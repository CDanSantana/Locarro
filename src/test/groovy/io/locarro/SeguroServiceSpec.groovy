package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SeguroServiceSpec extends Specification {

    SeguroService seguroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Seguro(...).save(flush: true, failOnError: true)
        //new Seguro(...).save(flush: true, failOnError: true)
        //Seguro seguro = new Seguro(...).save(flush: true, failOnError: true)
        //new Seguro(...).save(flush: true, failOnError: true)
        //new Seguro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //seguro.id
    }

    void "test get"() {
        setupData()

        expect:
        seguroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Seguro> seguroList = seguroService.list(max: 2, offset: 2)

        then:
        seguroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        seguroService.count() == 5
    }

    void "test delete"() {
        Long seguroId = setupData()

        expect:
        seguroService.count() == 5

        when:
        seguroService.delete(seguroId)
        sessionFactory.currentSession.flush()

        then:
        seguroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Seguro seguro = new Seguro()
        seguroService.save(seguro)

        then:
        seguro.id != null
    }
}
