package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PagamentoController extends RestfulController<Pagamento> {

    PagamentoService pagamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    PagamentoController() {
        super(Pagamento)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pagamentoService.list(params), model:[pagamentoCount: pagamentoService.count()]
    }

    def show(Long id) {
        respond pagamentoService.get(id)
    }

    def create() {
        respond new Pagamento(params)
    }

    def save(Pagamento pagamento) {
        if (pagamento == null) {
            notFound()
            return
        }
        try {
            pagamentoService.save(pagamento)
        } catch (ValidationException e) {
            respond pagamento.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), pagamento.id])
                redirect pagamento
            }
            '*' { respond pagamento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pagamentoService.get(id)
    }

    def update(Pagamento pagamento) {
        if (pagamento == null) {
            notFound()
            return
        }
        try {
            pagamentoService.save(pagamento)
        } catch (ValidationException e) {
            respond pagamento.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), pagamento.id])
                redirect pagamento
            }
            '*'{ respond pagamento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        pagamentoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
