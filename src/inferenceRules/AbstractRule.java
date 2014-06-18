package inferenceRules;

/**
 * Created by armando on 15/06/14.
 */
public abstract class AbstractRule implements IRuleInference{
    protected String negToken(String token){
        if(token.contains("¬")){
            return  token.replace("¬","");
        }else{
            return "¬"+token;
        }
    }
}
