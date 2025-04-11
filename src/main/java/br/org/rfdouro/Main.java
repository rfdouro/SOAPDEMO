package br.org.rfdouro;

import br.org.rfdouro.impl.CertidaoNascimentoImpl;
import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        CertidaoNascimentoImpl certidaoNascimento = new CertidaoNascimentoImpl();
        Endpoint.publish("http://0.0.0.0:8085/servico/certidao", certidaoNascimento);
        //Endpoint.publish("http://localhost:8085/servico/certidao", certidaoNascimento);
        System.out.println("Serviço rodando");

        /*CertidaoNascimentoImpl ci = new CertidaoNascimentoImpl();
        System.out.println(ci.diaSemanaNascimento("04/05/1978"));*/
    }
}