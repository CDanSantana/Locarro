package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ManutencaoController extends RestfulController<Manutencao> {

    ManutencaoService manutencaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    ManutencaoController() {
        super(Manutencao)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond manutencaoService.list(params), model:[manutencaoCount: manutencaoService.count()]
    }

    def show(Long id) {
        respond manutencaoService.get(id)
    }

    def create() {
        respond new Manutencao(params)
    }

    def save(Manutencao manutencao) {
        if (manutencao == null) {
            notFound()
            return
        }
        try {
            manutencaoService.save(manutencao)
        } catch (ValidationException e) {
            respond manutencao.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'manutencao.label', default: 'Manutencao'), manutencao.id])
                redirect manutencao
            }
            '*' { respond manutencao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond manutencaoService.get(id)
    }

    def update(Manutencao manutencao) {
        if (manutencao == null) {
            notFound()
            return
        }
        try {
            manutencaoService.save(manutencao)
        } catch (ValidationException e) {
            respond manutencao.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'manutencao.label', default: 'Manutencao'), manutencao.id])
                redirect manutencao
            }
            '*'{ respond manutencao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        manutencaoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'manutencao.label', default: 'Manutencao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'manutencao.label', default: 'Manutencao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
