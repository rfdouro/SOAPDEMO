package br.org.rfdouro.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.org.rfdouro.spec.Calculos;
import jakarta.jws.WebService;

@WebService(endpointInterface = "br.org.rfdouro.spec.Calculos")
public class CalculosImpl implements Calculos {

  private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  @Override
  public int calculaIdade(String dtNascimento) {
    int calc = 0;
    try {
      Calendar dtNasc = Calendar.getInstance();
      Date idade = sdf.parse(dtNascimento);
      dtNasc.setTime(idade);

      Calendar hoje = Calendar.getInstance();
      calc = hoje.get(Calendar.YEAR) - dtNasc.get(Calendar.YEAR);
      if (hoje.get(Calendar.MONTH) < dtNasc.get(Calendar.MONTH)) {
        calc--;
      } else if (hoje.get(Calendar.MONTH) == dtNasc.get(Calendar.MONTH)
          && hoje.get(Calendar.DAY_OF_MONTH) < dtNasc.get(Calendar.DAY_OF_MONTH)) {
        calc--;
      }
    } catch (ParseException e) {
    }
    return calc;
  }

  @Override
  public String diaSemanaNascimento(String dtNascimento) {
    String[] dias = { "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb" };
    int dia = 0;
    try {
      Calendar dtNasc = Calendar.getInstance();
      Date idade = sdf.parse(dtNascimento);
      dtNasc.setTime(idade);
      dia = dtNasc.get(Calendar.DAY_OF_WEEK);
    } catch (Exception e) {
    }
    return dias[dia - 1];
  }

  @Override
  public String diferencaIdade(String dtNascimento1, String dtNascimento2) {
    try {
      Calendar dtNasc1 = Calendar.getInstance();
      Date idade1 = sdf.parse(dtNascimento1);
      dtNasc1.setTime(idade1);

      Calendar dtNasc2 = Calendar.getInstance();
      Date idade2 = sdf.parse(dtNascimento2);
      dtNasc2.setTime(idade2);

      // Calcular a diferença em milissegundos
      long diferencaMillis = dtNasc1.getTimeInMillis() - dtNasc2.getTimeInMillis();

      // Calcular a diferença em dias
      long diferencaDias = diferencaMillis / (1000 * 60 * 60 * 24);

      return diferencaDias + "dias";

    } catch (ParseException e) {
      return "ERRO " + e.getMessage();
    }

  }

  @Override
  public Long hojeMillis() {
    Calendar hoje = Calendar.getInstance();
    return hoje.getTimeInMillis();
  }

}
