package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StatusReservaServiceSpec extends Specification {

    StatusReservaService statusReservaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new StatusReserva(...).save(flush: true, failOnError: true)
        //new StatusReserva(...).save(flush: true, failOnError: true)
        //StatusReserva statusReserva = new StatusReserva(...).save(flush: true, failOnError: true)
        //new StatusReserva(...).save(flush: true, failOnError: true)
        //new StatusReserva(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //statusReserva.id
    }

    void "test get"() {
        setupData()

        expect:
        statusReservaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<StatusReserva> statusReservaList = statusReservaService.list(max: 2, offset: 2)

        then:
        statusReservaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        statusReservaService.count() == 5
    }

    void "test delete"() {
        Long statusReservaId = setupData()

        expect:
        statusReservaService.count() == 5

        when:
        statusReservaService.delete(statusReservaId)
        sessionFactory.currentSession.flush()

        then:
        statusReservaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        StatusReserva statusReserva = new StatusReserva()
        statusReservaService.save(statusReserva)

        then:
        statusReserva.id != null
    }
}
