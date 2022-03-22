package br.mil.fab.ccarj.eavaliacaobq.eprocessoavaliativoapi.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String msg){
        super(msg);
    }
}
