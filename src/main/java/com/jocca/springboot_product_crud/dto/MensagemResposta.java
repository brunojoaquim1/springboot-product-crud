
package com.jocca.springboot_product_crud.dto;

public class MensagemResposta {

    private String mensagem;

    public MensagemResposta(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
