package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.service;

import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService <E> {
        E create (E entity);
        E findById (Long id) throws NotFoundException;
        Page<E> findAll (Pageable pageable);
        void update (Long id, E entity) throws NotFoundException;
        void delete (Long id);
}
