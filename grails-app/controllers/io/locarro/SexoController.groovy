package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SexoController extends RestfulController<Sexo> {

    SexoService sexoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    SexoController() {
        super(Sexo)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sexoService.list(params), model:[sexoCount: sexoService.count()]
    }

    def show(Long id) {
        respond sexoService.get(id)
    }

    def create() {
        respond new Sexo(params)
    }

    def save(Sexo sexo) {
        if (sexo == null) {
            notFound()
            return
        }
        try {
            sexoService.save(sexo)
        } catch (ValidationException e) {
            respond sexo.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sexo.label', default: 'Sexo'), sexo.id])
                redirect sexo
            }
            '*' { respond sexo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sexoService.get(id)
    }

    def update(Sexo sexo) {
        if (sexo == null) {
            notFound()
            return
        }
        try {
            sexoService.save(sexo)
        } catch (ValidationException e) {
            respond sexo.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sexo.label', default: 'Sexo'), sexo.id])
                redirect sexo
            }
            '*'{ respond sexo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        sexoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sexo.label', default: 'Sexo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sexo.label', default: 'Sexo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
