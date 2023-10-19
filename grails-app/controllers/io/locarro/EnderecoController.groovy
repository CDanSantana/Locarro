package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EnderecoController extends RestfulController<Endereco> {

    EnderecoService enderecoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    EnderecoController() {
        super(Endereco)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond enderecoService.list(params), model:[enderecoCount: enderecoService.count()]
    }

    def show(Long id) {
        respond enderecoService.get(id)
    }

    def create() {
        respond new Endereco(params)
    }

    def save(Endereco endereco) {
        if (endereco == null) {
            notFound()
            return
        }
        try {
            enderecoService.save(endereco)
        } catch (ValidationException e) {
            respond endereco.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'endereco.label', default: 'Endereco'), endereco.id])
                redirect endereco
            }
            '*' { respond endereco, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond enderecoService.get(id)
    }

    def update(Endereco endereco) {
        if (endereco == null) {
            notFound()
            return
        }
        try {
            enderecoService.save(endereco)
        } catch (ValidationException e) {
            respond endereco.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'endereco.label', default: 'Endereco'), endereco.id])
                redirect endereco
            }
            '*'{ respond endereco, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        enderecoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'endereco.label', default: 'Endereco'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'endereco.label', default: 'Endereco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
