package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StatusAluguelController extends RestfulController<StatusAluguel> {

    StatusAluguelService statusAluguelService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    StatusAluguelController() {
        super(StatusAluguel)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond statusAluguelService.list(params), model:[statusAluguelCount: statusAluguelService.count()]
    }

    def show(Long id) {
        respond statusAluguelService.get(id)
    }

    def create() {
        respond new StatusAluguel(params)
    }

    def save(StatusAluguel statusAluguel) {
        if (statusAluguel == null) {
            notFound()
            return
        }
        try {
            statusAluguelService.save(statusAluguel)
        } catch (ValidationException e) {
            respond statusAluguel.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statusAluguel.label', default: 'StatusAluguel'), statusAluguel.id])
                redirect statusAluguel
            }
            '*' { respond statusAluguel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond statusAluguelService.get(id)
    }

    def update(StatusAluguel statusAluguel) {
        if (statusAluguel == null) {
            notFound()
            return
        }
        try {
            statusAluguelService.save(statusAluguel)
        } catch (ValidationException e) {
            respond statusAluguel.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'statusAluguel.label', default: 'StatusAluguel'), statusAluguel.id])
                redirect statusAluguel
            }
            '*'{ respond statusAluguel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        statusAluguelService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'statusAluguel.label', default: 'StatusAluguel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusAluguel.label', default: 'StatusAluguel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
