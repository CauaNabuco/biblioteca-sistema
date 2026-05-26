package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaTelefone {
    public boolean validarTelefone (String numero) {
        String regex = "[0-9]{11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        if (matcher.matches()){
            return true;
        }
        return false;
    }
}
