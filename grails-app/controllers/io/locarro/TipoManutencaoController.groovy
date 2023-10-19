package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoManutencaoController extends RestfulController<TipoManutencao> {

    TipoManutencaoService tipoManutencaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    TipoManutencaoController() {
        super(TipoManutencao)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoManutencaoService.list(params), model:[tipoManutencaoCount: tipoManutencaoService.count()]
    }

    def show(Long id) {
        respond tipoManutencaoService.get(id)
    }

    def create() {
        respond new TipoManutencao(params)
    }

    def save(TipoManutencao tipoManutencao) {
        if (tipoManutencao == null) {
            notFound()
            return
        }
        try {
            tipoManutencaoService.save(tipoManutencao)
        } catch (ValidationException e) {
            respond tipoManutencao.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoManutencao.label', default: 'TipoManutencao'), tipoManutencao.id])
                redirect tipoManutencao
            }
            '*' { respond tipoManutencao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoManutencaoService.get(id)
    }

    def update(TipoManutencao tipoManutencao) {
        if (tipoManutencao == null) {
            notFound()
            return
        }
        try {
            tipoManutencaoService.save(tipoManutencao)
        } catch (ValidationException e) {
            respond tipoManutencao.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoManutencao.label', default: 'TipoManutencao'), tipoManutencao.id])
                redirect tipoManutencao
            }
            '*'{ respond tipoManutencao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        tipoManutencaoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoManutencao.label', default: 'TipoManutencao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoManutencao.label', default: 'TipoManutencao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
