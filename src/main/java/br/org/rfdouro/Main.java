package br.org.rfdouro;

import br.org.rfdouro.impl.CalculosImpl;
import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        CalculosImpl calculos = new CalculosImpl();
        Endpoint.publish("http://0.0.0.0:8085/servico/calculos", calculos);
        //Endpoint.publish("http://localhost:8085/servico/calculos", calculos);
        System.out.println("Serviço rodando em http://localhost:8085/servico/calculos?wsdl");
        System.out.println("Descrição rodando em http://localhost:8085/servico/calculos?wsdl=1");

        /*calculosImpl ci = new calculosImpl();
        System.out.println(ci.diaSemanaNascimento("04/05/1978"));*/
    }
}