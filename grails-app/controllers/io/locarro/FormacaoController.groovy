package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FormacaoController extends RestfulController<Formacao> {

    FormacaoService formacaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    FormacaoController() {
        super(Formacao)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond formacaoService.list(params), model:[formacaoCount: formacaoService.count()]
    }

    def show(Long id) {
        respond formacaoService.get(id)
    }

    def create() {
        respond new Formacao(params)
    }

    def save(Formacao formacao) {
        if (formacao == null) {
            notFound()
            return
        }
        try {
            formacaoService.save(formacao)
        } catch (ValidationException e) {
            respond formacao.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'formacao.label', default: 'Formacao'), formacao.id])
                redirect formacao
            }
            '*' { respond formacao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond formacaoService.get(id)
    }

    def update(Formacao formacao) {
        if (formacao == null) {
            notFound()
            return
        }
        try {
            formacaoService.save(formacao)
        } catch (ValidationException e) {
            respond formacao.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'formacao.label', default: 'Formacao'), formacao.id])
                redirect formacao
            }
            '*'{ respond formacao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        formacaoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'formacao.label', default: 'Formacao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'formacao.label', default: 'Formacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
