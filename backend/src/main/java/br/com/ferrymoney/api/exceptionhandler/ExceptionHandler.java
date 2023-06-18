package br.com.ferrymoney.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        String messageDev = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
        return handleExceptionInternal(ex, Arrays.asList(new Erro(messageUsuario, messageDev)), headers,
                HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        return handleExceptionInternal(ex, criaListaDeErro(ex.getBindingResult()), headers, status, request);
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { EntityNotFoundException.class })
    public void entityNotFoundException() {
        /* TODO document why this method is empty */ }

    private List<Erro> criaListaDeErro(BindingResult bindingResult) {
        ArrayList<Erro> erros = new ArrayList<>();
        for (FieldError field : bindingResult.getFieldErrors()) {
            String msgUsuario = messageSource.getMessage(field, LocaleContextHolder.getLocale());
            String msgDev = field.toString();
            erros.add(new Erro(msgUsuario, msgDev));
        }
        return erros;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Erro {
        private String mensagemUsuario;
        private String mensagemDev;
    }
}
