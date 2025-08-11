
package com.jocca.springboot_product_crud.dto;

import java.time.Instant;

public class APIResponse<T>  {

    private String mensagem;
    private T data;
    private Instant timestamp = Instant.now();

    public APIResponse() {}

    public APIResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public APIResponse(String mensagem, T data) {
        this.mensagem = mensagem;
        this.data = data;
    }

    // Factories para deixar bonito de usar
    public static <T> APIResponse<T> of(String mensagem, T data) {
        return new APIResponse<>(mensagem, data);
    }

    public static APIResponse<Void> of(String mensagem) {
        return new APIResponse<>(mensagem);
    }

    // getters e setters
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
