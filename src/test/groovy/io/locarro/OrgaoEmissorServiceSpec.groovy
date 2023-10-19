package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrgaoEmissorServiceSpec extends Specification {

    OrgaoEmissorService orgaoEmissorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OrgaoEmissor(...).save(flush: true, failOnError: true)
        //new OrgaoEmissor(...).save(flush: true, failOnError: true)
        //OrgaoEmissor orgaoEmissor = new OrgaoEmissor(...).save(flush: true, failOnError: true)
        //new OrgaoEmissor(...).save(flush: true, failOnError: true)
        //new OrgaoEmissor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //orgaoEmissor.id
    }

    void "test get"() {
        setupData()

        expect:
        orgaoEmissorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OrgaoEmissor> orgaoEmissorList = orgaoEmissorService.list(max: 2, offset: 2)

        then:
        orgaoEmissorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        orgaoEmissorService.count() == 5
    }

    void "test delete"() {
        Long orgaoEmissorId = setupData()

        expect:
        orgaoEmissorService.count() == 5

        when:
        orgaoEmissorService.delete(orgaoEmissorId)
        sessionFactory.currentSession.flush()

        then:
        orgaoEmissorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OrgaoEmissor orgaoEmissor = new OrgaoEmissor()
        orgaoEmissorService.save(orgaoEmissor)

        then:
        orgaoEmissor.id != null
    }
}
