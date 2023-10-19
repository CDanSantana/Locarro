package io.locarro

import grails.gorm.services.Service

@Service(OrgaoEmissor)
abstract class OrgaoEmissorService implements IOrgaoEmissorService {

    /*@Override
    List<OrgaoEmissor> list(Map args){
        return OrgaoEmissor.createCriteria().list(sort: args.sort, max: args.max, offset: args.offset){
            order(args.sort, args.order)
        }
    }*/

}

interface IOrgaoEmissorService {

    OrgaoEmissor get(Serializable id)

    Long count()

    void delete(Serializable id)

    OrgaoEmissor save(OrgaoEmissor orgaoEmissor)

    List<OrgaoEmissor> list(Map args)

}
