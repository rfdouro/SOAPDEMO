package br.org.rfdouro.spec;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CertidaoNascimento {

 @WebMethod
 int calculaIdade(String dtNascimento);

 @WebMethod
 String diaSemanaNascimento(String dtNascimento);

}
