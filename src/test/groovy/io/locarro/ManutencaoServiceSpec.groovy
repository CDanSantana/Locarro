package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ManutencaoServiceSpec extends Specification {

    ManutencaoService manutencaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Manutencao(...).save(flush: true, failOnError: true)
        //new Manutencao(...).save(flush: true, failOnError: true)
        //Manutencao manutencao = new Manutencao(...).save(flush: true, failOnError: true)
        //new Manutencao(...).save(flush: true, failOnError: true)
        //new Manutencao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //manutencao.id
    }

    void "test get"() {
        setupData()

        expect:
        manutencaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Manutencao> manutencaoList = manutencaoService.list(max: 2, offset: 2)

        then:
        manutencaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        manutencaoService.count() == 5
    }

    void "test delete"() {
        Long manutencaoId = setupData()

        expect:
        manutencaoService.count() == 5

        when:
        manutencaoService.delete(manutencaoId)
        sessionFactory.currentSession.flush()

        then:
        manutencaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Manutencao manutencao = new Manutencao()
        manutencaoService.save(manutencao)

        then:
        manutencao.id != null
    }
}
