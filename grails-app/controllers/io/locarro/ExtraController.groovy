package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExtraController extends RestfulController<Extra> {

    ExtraService extraService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    ExtraController() {
        super(Extra)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond extraService.list(params), model:[extraCount: extraService.count()]
    }

    def show(Long id) {
        respond extraService.get(id)
    }

    def create() {
        respond new Extra(params)
    }

    def save(Extra extra) {
        if (extra == null) {
            notFound()
            return
        }
        try {
            extraService.save(extra)
        } catch (ValidationException e) {
            respond extra.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'extra.label', default: 'Extra'), extra.id])
                redirect extra
            }
            '*' { respond extra, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond extraService.get(id)
    }

    def update(Extra extra) {
        if (extra == null) {
            notFound()
            return
        }
        try {
            extraService.save(extra)
        } catch (ValidationException e) {
            respond extra.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'extra.label', default: 'Extra'), extra.id])
                redirect extra
            }
            '*'{ respond extra, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        extraService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'extra.label', default: 'Extra'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'extra.label', default: 'Extra'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
