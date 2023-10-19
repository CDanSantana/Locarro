package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoEnderecoController extends RestfulController<TipoEndereco> {

    TipoEnderecoService tipoEnderecoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    TipoEnderecoController() {
        super(TipoEndereco)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoEnderecoService.list(params), model:[tipoEnderecoCount: tipoEnderecoService.count()]
    }

    def show(Long id) {
        respond tipoEnderecoService.get(id)
    }

    def create() {
        respond new TipoEndereco(params)
    }

    def save(TipoEndereco tipoEndereco) {
        if (tipoEndereco == null) {
            notFound()
            return
        }
        try {
            tipoEnderecoService.save(tipoEndereco)
        } catch (ValidationException e) {
            respond tipoEndereco.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoEndereco.label', default: 'TipoEndereco'), tipoEndereco.id])
                redirect tipoEndereco
            }
            '*' { respond tipoEndereco, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoEnderecoService.get(id)
    }

    def update(TipoEndereco tipoEndereco) {
        if (tipoEndereco == null) {
            notFound()
            return
        }
        try {
            tipoEnderecoService.save(tipoEndereco)
        } catch (ValidationException e) {
            respond tipoEndereco.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoEndereco.label', default: 'TipoEndereco'), tipoEndereco.id])
                redirect tipoEndereco
            }
            '*'{ respond tipoEndereco, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        tipoEnderecoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoEndereco.label', default: 'TipoEndereco'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoEndereco.label', default: 'TipoEndereco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
