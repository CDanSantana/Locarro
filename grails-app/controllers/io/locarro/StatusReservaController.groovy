package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StatusReservaController extends RestfulController<StatusReserva> {

    StatusReservaService statusReservaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    StatusReservaController() {
        super(StatusReserva)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond statusReservaService.list(params), model:[statusReservaCount: statusReservaService.count()]
    }

    def show(Long id) {
        respond statusReservaService.get(id)
    }

    def create() {
        respond new StatusReserva(params)
    }

    def save(StatusReserva statusReserva) {
        if (statusReserva == null) {
            notFound()
            return
        }
        try {
            statusReservaService.save(statusReserva)
        } catch (ValidationException e) {
            respond statusReserva.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statusReserva.label', default: 'StatusReserva'), statusReserva.id])
                redirect statusReserva
            }
            '*' { respond statusReserva, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond statusReservaService.get(id)
    }

    def update(StatusReserva statusReserva) {
        if (statusReserva == null) {
            notFound()
            return
        }
        try {
            statusReservaService.save(statusReserva)
        } catch (ValidationException e) {
            respond statusReserva.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'statusReserva.label', default: 'StatusReserva'), statusReserva.id])
                redirect statusReserva
            }
            '*'{ respond statusReserva, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        statusReservaService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'statusReserva.label', default: 'StatusReserva'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusReserva.label', default: 'StatusReserva'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
