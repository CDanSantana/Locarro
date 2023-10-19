package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SexoServiceSpec extends Specification {

    SexoService sexoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Sexo(...).save(flush: true, failOnError: true)
        //new Sexo(...).save(flush: true, failOnError: true)
        //Sexo sexo = new Sexo(...).save(flush: true, failOnError: true)
        //new Sexo(...).save(flush: true, failOnError: true)
        //new Sexo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sexo.id
    }

    void "test get"() {
        setupData()

        expect:
        sexoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Sexo> sexoList = sexoService.list(max: 2, offset: 2)

        then:
        sexoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sexoService.count() == 5
    }

    void "test delete"() {
        Long sexoId = setupData()

        expect:
        sexoService.count() == 5

        when:
        sexoService.delete(sexoId)
        sessionFactory.currentSession.flush()

        then:
        sexoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Sexo sexo = new Sexo()
        sexoService.save(sexo)

        then:
        sexo.id != null
    }
}
