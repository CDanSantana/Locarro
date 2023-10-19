package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoManutencaoServiceSpec extends Specification {

    TipoManutencaoService tipoManutencaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoManutencao(...).save(flush: true, failOnError: true)
        //new TipoManutencao(...).save(flush: true, failOnError: true)
        //TipoManutencao tipoManutencao = new TipoManutencao(...).save(flush: true, failOnError: true)
        //new TipoManutencao(...).save(flush: true, failOnError: true)
        //new TipoManutencao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoManutencao.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoManutencaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoManutencao> tipoManutencaoList = tipoManutencaoService.list(max: 2, offset: 2)

        then:
        tipoManutencaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoManutencaoService.count() == 5
    }

    void "test delete"() {
        Long tipoManutencaoId = setupData()

        expect:
        tipoManutencaoService.count() == 5

        when:
        tipoManutencaoService.delete(tipoManutencaoId)
        sessionFactory.currentSession.flush()

        then:
        tipoManutencaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoManutencao tipoManutencao = new TipoManutencao()
        tipoManutencaoService.save(tipoManutencao)

        then:
        tipoManutencao.id != null
    }
}
