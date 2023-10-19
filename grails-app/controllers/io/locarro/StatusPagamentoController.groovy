package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StatusPagamentoController extends RestfulController<StatusPagamento> {

    StatusPagamentoService statusPagamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    StatusPagamentoController() {
        super(StatusPagamento)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond statusPagamentoService.list(params), model:[statusPagamentoCount: statusPagamentoService.count()]
    }

    def show(Long id) {
        respond statusPagamentoService.get(id)
    }

    def create() {
        respond new StatusPagamento(params)
    }

    def save(StatusPagamento statusPagamento) {
        if (statusPagamento == null) {
            notFound()
            return
        }
        try {
            statusPagamentoService.save(statusPagamento)
        } catch (ValidationException e) {
            respond statusPagamento.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statusPagamento.label', default: 'StatusPagamento'), statusPagamento.id])
                redirect statusPagamento
            }
            '*' { respond statusPagamento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond statusPagamentoService.get(id)
    }

    def update(StatusPagamento statusPagamento) {
        if (statusPagamento == null) {
            notFound()
            return
        }
        try {
            statusPagamentoService.save(statusPagamento)
        } catch (ValidationException e) {
            respond statusPagamento.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'statusPagamento.label', default: 'StatusPagamento'), statusPagamento.id])
                redirect statusPagamento
            }
            '*'{ respond statusPagamento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        statusPagamentoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'statusPagamento.label', default: 'StatusPagamento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusPagamento.label', default: 'StatusPagamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
