package io.locarro

class BootStrap {
    CidadesService cidadesService

    def init = { servletContext ->
      if(io.locarro.Estado.count()<=0){
        [['São Paulo', 'SP',], ['Paraná', 'PR',], ['Santa Catarina', 'SC',], ['Rio Grande do Sul', 'RS',], ['Mato Grosso do Sul', 'MS',], ['Rondônia', 'RO',], ['Acre', 'AC',], ['Amazonas', 'AM',], ['Roraima', 'RR',], ['Pará', 'PA',], ['Amapá', 'AP',], ['Tocantins', 'TO',], ['Maranhão', 'MA',], ['Rio Grande do Norte', 'RN',], ['Paraíba', 'PB',], ['Pernambuco', 'PE',], ['Alagoas', 'AL',], ['Sergipe', 'SE',], ['Bahia', 'BA',], ['Minas Gerais', 'MG',], ['Rio de Janeiro', 'RJ',], ['Mato Grosso', 'MT',], ['Goiás', 'GO',], ['Distrito Federal', 'DF',], ['Piauí', 'PI',], ['Ceará', 'CE',], ['Espírito Santo', 'ES',]].each{estado->
            new io.locarro.Estado(nome: estado[0].trim(), sigla: estado[1].trim()).save(failOnError: true)
        }
        cidadesService.populateCidades()
        ['Fundamental - Incompleto', 'Fundamental - Completo', 'Médio - Incompleto', 'Médio - Completo', 'Técnico - Incompleto', 'Técnico - Completo', 'Profissionalizante - Incompleto', 'Profissionalizante - Completo', 'Superior - Incompleto', 'Superior - Completo', 'Pós-graduação (Lato senso) - Incompleto', 'Pós-graduação (Lato senso) - Completo', 'Pós-graduação (Stricto sensu, nível mestrado) - Incompleto', 'Pós-graduação (Stricto sensu, nível mestrado) - Completo', 'Pós-graduação (Stricto sensu, nível doutor) - Incompleto', 'Pós-graduação (Stricto sensu, nível doutor) - CompletoElemento', 'Sem Formação'].each{formacao->
            new io.locarro.Formacao(nome: formacao).save(failOnError: true)
        }
        [['Masculino', 'MSC'], ['Feminino', 'FMN'], ['Outro', 'OTR'], ['Não Informado', 'NIN']].each{sexo->
            new io.locarro.Sexo(nome: sexo[0], sigla: sexo[1]).save(failOnError: true)
        }
        ['Celular Pessoal', 'Celular Empresarial', 'Telefone Fixo Residencial', 'Telefone Fixo Empresarial'].each{tipoTelefone->
            new io.locarro.TipoTelefone(nome: tipoTelefone).save(failOnError: true)
        }
        ['Residencial', 'Empresarial'].each{tipoEndereco->
            new io.locarro.TipoEndereco(nome: tipoEndereco).save(failOnError: true)
        }
        [['Secretaria de Segurança Pública', 'SSP'], ['Departamento de Trânsito', 'Detran'], ['Polícia Militar', 'POM'], ['Secretaria de Polícia Técnico-Científica', 'SPTC'], ['Fundo de Garantia do Tempo de Serviço', 'FGTS'], ['Ordem dos Advogados do Brasil', 'OAB'], ['Ministério do Trabalho e Emprego', 'MTE'], ['Cartório Civil', 'CV'], ['Departamento de Polícia Federal', 'DPF']].each{oem->
            io.locarro.Estado.list().each{estado->
                new io.locarro.OrgaoEmissor(nome: oem[0], sigla: oem[1], estado: estado).save(failOnError: true)
            }
        }
      }
    }
    def destroy = {
    }

}
