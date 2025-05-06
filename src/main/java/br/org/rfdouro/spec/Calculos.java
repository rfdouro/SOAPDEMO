package br.org.rfdouro.spec;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface Calculos {

 @WebMethod
 int calculaIdade(String dtNascimento);

 @WebMethod
 String diaSemanaNascimento(String dtNascimento);

 @WebMethod
 String diferencaIdade(String dtNascimento1, String dtNascimento2);

 @WebMethod
 Long hojeMillis();

}
