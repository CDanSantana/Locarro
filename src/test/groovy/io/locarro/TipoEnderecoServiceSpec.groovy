package io.locarro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoEnderecoServiceSpec extends Specification {

    TipoEnderecoService tipoEnderecoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoEndereco(...).save(flush: true, failOnError: true)
        //new TipoEndereco(...).save(flush: true, failOnError: true)
        //TipoEndereco tipoEndereco = new TipoEndereco(...).save(flush: true, failOnError: true)
        //new TipoEndereco(...).save(flush: true, failOnError: true)
        //new TipoEndereco(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoEndereco.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoEnderecoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoEndereco> tipoEnderecoList = tipoEnderecoService.list(max: 2, offset: 2)

        then:
        tipoEnderecoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoEnderecoService.count() == 5
    }

    void "test delete"() {
        Long tipoEnderecoId = setupData()

        expect:
        tipoEnderecoService.count() == 5

        when:
        tipoEnderecoService.delete(tipoEnderecoId)
        sessionFactory.currentSession.flush()

        then:
        tipoEnderecoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoEndereco tipoEndereco = new TipoEndereco()
        tipoEnderecoService.save(tipoEndereco)

        then:
        tipoEndereco.id != null
    }
}
