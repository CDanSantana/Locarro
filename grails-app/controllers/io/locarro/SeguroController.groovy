package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SeguroController extends RestfulController<Seguro> {

    SeguroService seguroService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    SeguroController() {
        super(Seguro)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond seguroService.list(params), model:[seguroCount: seguroService.count()]
    }

    def show(Long id) {
        respond seguroService.get(id)
    }

    def create() {
        respond new Seguro(params)
    }

    def save(Seguro seguro) {
        if (seguro == null) {
            notFound()
            return
        }
        try {
            seguroService.save(seguro)
        } catch (ValidationException e) {
            respond seguro.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seguro.label', default: 'Seguro'), seguro.id])
                redirect seguro
            }
            '*' { respond seguro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond seguroService.get(id)
    }

    def update(Seguro seguro) {
        if (seguro == null) {
            notFound()
            return
        }
        try {
            seguroService.save(seguro)
        } catch (ValidationException e) {
            respond seguro.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'seguro.label', default: 'Seguro'), seguro.id])
                redirect seguro
            }
            '*'{ respond seguro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        seguroService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'seguro.label', default: 'Seguro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'seguro.label', default: 'Seguro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
