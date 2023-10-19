package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoTelefoneController extends RestfulController<TipoTelefone> {

    TipoTelefoneService tipoTelefoneService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    TipoTelefoneController() {
        super(TipoTelefone)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoTelefoneService.list(params), model:[tipoTelefoneCount: tipoTelefoneService.count()]
    }

    def show(Long id) {
        respond tipoTelefoneService.get(id)
    }

    def create() {
        respond new TipoTelefone(params)
    }

    def save(TipoTelefone tipoTelefone) {
        if (tipoTelefone == null) {
            notFound()
            return
        }
        try {
            tipoTelefoneService.save(tipoTelefone)
        } catch (ValidationException e) {
            respond tipoTelefone.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoTelefone.label', default: 'TipoTelefone'), tipoTelefone.id])
                redirect tipoTelefone
            }
            '*' { respond tipoTelefone, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoTelefoneService.get(id)
    }

    def update(TipoTelefone tipoTelefone) {
        if (tipoTelefone == null) {
            notFound()
            return
        }
        try {
            tipoTelefoneService.save(tipoTelefone)
        } catch (ValidationException e) {
            respond tipoTelefone.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoTelefone.label', default: 'TipoTelefone'), tipoTelefone.id])
                redirect tipoTelefone
            }
            '*'{ respond tipoTelefone, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        tipoTelefoneService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoTelefone.label', default: 'TipoTelefone'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoTelefone.label', default: 'TipoTelefone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
