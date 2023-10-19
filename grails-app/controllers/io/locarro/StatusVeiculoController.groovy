package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StatusVeiculoController extends RestfulController<StatusVeiculo> {

    StatusVeiculoService statusVeiculoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    StatusVeiculoController() {
        super(StatusVeiculo)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond statusVeiculoService.list(params), model:[statusVeiculoCount: statusVeiculoService.count()]
    }

    def show(Long id) {
        respond statusVeiculoService.get(id)
    }

    def create() {
        respond new StatusVeiculo(params)
    }

    def save(StatusVeiculo statusVeiculo) {
        if (statusVeiculo == null) {
            notFound()
            return
        }
        try {
            statusVeiculoService.save(statusVeiculo)
        } catch (ValidationException e) {
            respond statusVeiculo.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statusVeiculo.label', default: 'StatusVeiculo'), statusVeiculo.id])
                redirect statusVeiculo
            }
            '*' { respond statusVeiculo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond statusVeiculoService.get(id)
    }

    def update(StatusVeiculo statusVeiculo) {
        if (statusVeiculo == null) {
            notFound()
            return
        }
        try {
            statusVeiculoService.save(statusVeiculo)
        } catch (ValidationException e) {
            respond statusVeiculo.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'statusVeiculo.label', default: 'StatusVeiculo'), statusVeiculo.id])
                redirect statusVeiculo
            }
            '*'{ respond statusVeiculo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        statusVeiculoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'statusVeiculo.label', default: 'StatusVeiculo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusVeiculo.label', default: 'StatusVeiculo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
