package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MetodoPagamentoController extends RestfulController<MetodoPagamento> {

    MetodoPagamentoService metodoPagamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    MetodoPagamentoController() {
        super(MetodoPagamento)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond metodoPagamentoService.list(params), model:[metodoPagamentoCount: metodoPagamentoService.count()]
    }

    def show(Long id) {
        respond metodoPagamentoService.get(id)
    }

    def create() {
        respond new MetodoPagamento(params)
    }

    def save(MetodoPagamento metodoPagamento) {
        if (metodoPagamento == null) {
            notFound()
            return
        }
        try {
            metodoPagamentoService.save(metodoPagamento)
        } catch (ValidationException e) {
            respond metodoPagamento.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'metodoPagamento.label', default: 'MetodoPagamento'), metodoPagamento.id])
                redirect metodoPagamento
            }
            '*' { respond metodoPagamento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond metodoPagamentoService.get(id)
    }

    def update(MetodoPagamento metodoPagamento) {
        if (metodoPagamento == null) {
            notFound()
            return
        }
        try {
            metodoPagamentoService.save(metodoPagamento)
        } catch (ValidationException e) {
            respond metodoPagamento.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'metodoPagamento.label', default: 'MetodoPagamento'), metodoPagamento.id])
                redirect metodoPagamento
            }
            '*'{ respond metodoPagamento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        metodoPagamentoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'metodoPagamento.label', default: 'MetodoPagamento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'metodoPagamento.label', default: 'MetodoPagamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
