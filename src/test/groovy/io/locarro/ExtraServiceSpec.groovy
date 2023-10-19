package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExtraServiceSpec extends Specification {

    ExtraService extraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Extra(...).save(flush: true, failOnError: true)
        //new Extra(...).save(flush: true, failOnError: true)
        //Extra extra = new Extra(...).save(flush: true, failOnError: true)
        //new Extra(...).save(flush: true, failOnError: true)
        //new Extra(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //extra.id
    }

    void "test get"() {
        setupData()

        expect:
        extraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Extra> extraList = extraService.list(max: 2, offset: 2)

        then:
        extraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        extraService.count() == 5
    }

    void "test delete"() {
        Long extraId = setupData()

        expect:
        extraService.count() == 5

        when:
        extraService.delete(extraId)
        sessionFactory.currentSession.flush()

        then:
        extraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Extra extra = new Extra()
        extraService.save(extra)

        then:
        extra.id != null
    }
}
