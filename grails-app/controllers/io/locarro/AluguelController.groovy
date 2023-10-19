package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AluguelController extends RestfulController<Aluguel> {

    AluguelService aluguelService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    AluguelController() {
        super(Aluguel)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond aluguelService.list(params), model:[aluguelCount: aluguelService.count()]
    }

    def show(Long id) {
        respond aluguelService.get(id)
    }

    def create() {
        respond new Aluguel(params)
    }

    def save(Aluguel aluguel) {
        if (aluguel == null) {
            notFound()
            return
        }
        try {
            aluguelService.save(aluguel)
        } catch (ValidationException e) {
            respond aluguel.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), aluguel.id])
                redirect aluguel
            }
            '*' { respond aluguel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond aluguelService.get(id)
    }

    def update(Aluguel aluguel) {
        if (aluguel == null) {
            notFound()
            return
        }
        try {
            aluguelService.save(aluguel)
        } catch (ValidationException e) {
            respond aluguel.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), aluguel.id])
                redirect aluguel
            }
            '*'{ respond aluguel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        aluguelService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aluguel.label', default: 'Aluguel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
