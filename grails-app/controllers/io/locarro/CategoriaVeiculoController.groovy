package io.locarro

import grails.rest.*
import grails.converters.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CategoriaVeiculoController extends RestfulController<CategoriaVeiculo> {

    CategoriaVeiculoService categoriaVeiculoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    CategoriaVeiculoController() {
        super(CategoriaVeiculo)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriaVeiculoService.list(params), model:[categoriaVeiculoCount: categoriaVeiculoService.count()]
    }

    def show(Long id) {
        respond categoriaVeiculoService.get(id)
    }

    def create() {
        respond new CategoriaVeiculo(params)
    }

    def save(CategoriaVeiculo categoriaVeiculo) {
        if (categoriaVeiculo == null) {
            notFound()
            return
        }
        try {
            categoriaVeiculoService.save(categoriaVeiculo)
        } catch (ValidationException e) {
            respond categoriaVeiculo.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoriaVeiculo.label', default: 'CategoriaVeiculo'), categoriaVeiculo.id])
                redirect categoriaVeiculo
            }
            '*' { respond categoriaVeiculo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond categoriaVeiculoService.get(id)
    }

    def update(CategoriaVeiculo categoriaVeiculo) {
        if (categoriaVeiculo == null) {
            notFound()
            return
        }
        try {
            categoriaVeiculoService.save(categoriaVeiculo)
        } catch (ValidationException e) {
            respond categoriaVeiculo.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoriaVeiculo.label', default: 'CategoriaVeiculo'), categoriaVeiculo.id])
                redirect categoriaVeiculo
            }
            '*'{ respond categoriaVeiculo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        categoriaVeiculoService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoriaVeiculo.label', default: 'CategoriaVeiculo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoriaVeiculo.label', default: 'CategoriaVeiculo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
