package br.com.softplan.api.rest.service.pessoas.util.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceException extends Exception {

    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
