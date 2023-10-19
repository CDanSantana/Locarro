package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VeiculoController extends RestfulController<Veiculo> {

    VeiculoService veiculoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    VeiculoController() {
        super(Veiculo)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond veiculoService.list(params), model:[veiculoCount: veiculoService.count()]
    }

    def show(Long id) {
        respond veiculoService.get(id)
    }

    def create() {
        respond new Veiculo(params)
    }

    def save(Veiculo veiculo) {
        if (veiculo == null) {
            notFound()
            return
        }
        try {
            veiculoService.save(veiculo)
        } catch (ValidationException e) {
            respond veiculo.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'veiculo.label', default: 'Veiculo'), veiculo.id])
                redirect veiculo
            }
            '*' { respond veiculo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond veiculoService.get(id)
    }

    def update(Veiculo veiculo) {
        if (veiculo == null) {
            notFound()
            return
        }
        try {
            veiculoService.save(veiculo)
        } catch (ValidationException e) {
            respond veiculo.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'veiculo.label', default: 'Veiculo'), veiculo.id])
                redirect veiculo
            }
            '*'{ respond veiculo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        veiculoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'veiculo.label', default: 'Veiculo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'veiculo.label', default: 'Veiculo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
