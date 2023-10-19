package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrgaoEmissorController extends RestfulController<OrgaoEmissor> {

    OrgaoEmissorService orgaoEmissorService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    OrgaoEmissorController() {
        super(OrgaoEmissor)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orgaoEmissorService.list(params), model:[orgaoEmissorCount: orgaoEmissorService.count()]
    }

    def show(Long id) {
        respond orgaoEmissorService.get(id)
    }

    def create() {
        respond new OrgaoEmissor(params)
    }

    def save(OrgaoEmissor orgaoEmissor) {
        if (orgaoEmissor == null) {
            notFound()
            return
        }
        try {
            orgaoEmissorService.save(orgaoEmissor)
        } catch (ValidationException e) {
            respond orgaoEmissor.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orgaoEmissor.label', default: 'OrgaoEmissor'), orgaoEmissor.id])
                redirect orgaoEmissor
            }
            '*' { respond orgaoEmissor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond orgaoEmissorService.get(id)
    }

    def update(OrgaoEmissor orgaoEmissor) {
        if (orgaoEmissor == null) {
            notFound()
            return
        }
        try {
            orgaoEmissorService.save(orgaoEmissor)
        } catch (ValidationException e) {
            respond orgaoEmissor.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orgaoEmissor.label', default: 'OrgaoEmissor'), orgaoEmissor.id])
                redirect orgaoEmissor
            }
            '*'{ respond orgaoEmissor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        orgaoEmissorService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orgaoEmissor.label', default: 'OrgaoEmissor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orgaoEmissor.label', default: 'OrgaoEmissor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
