package br.com.ferrymoney.api.exceptionhandler;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String messageUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String messageDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new Erro(messageUsuario, messageDev), headers, HttpStatus.BAD_REQUEST,
                request);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Erro {
        private String mensagemUsuario;
        private String mensagemDev;
    }
}
