package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TelefoneController extends RestfulController<Telefone> {

    TelefoneService telefoneService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    TelefoneController() {
        super(Telefone)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond telefoneService.list(params), model:[telefoneCount: telefoneService.count()]
    }

    def show(Long id) {
        respond telefoneService.get(id)
    }

    def create() {
        respond new Telefone(params)
    }

    def save(Telefone telefone) {
        if (telefone == null) {
            notFound()
            return
        }
        try {
            telefoneService.save(telefone)
        } catch (ValidationException e) {
            respond telefone.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'telefone.label', default: 'Telefone'), telefone.id])
                redirect telefone
            }
            '*' { respond telefone, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond telefoneService.get(id)
    }

    def update(Telefone telefone) {
        if (telefone == null) {
            notFound()
            return
        }
        try {
            telefoneService.save(telefone)
        } catch (ValidationException e) {
            respond telefone.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'telefone.label', default: 'Telefone'), telefone.id])
                redirect telefone
            }
            '*'{ respond telefone, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        telefoneService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'telefone.label', default: 'Telefone'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'telefone.label', default: 'Telefone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
