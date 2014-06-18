package inferenceRules;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by armando on 10/06/14.
 */
public class ModusTolens extends AbstractRule{

    FactContainer container;

    @Override
    public boolean exec(String rule, FactContainer facts, FactContainer inferedFacts, ArrayList<String> sentences) {
        if(rule.contains("->")){
            StringTokenizer tokens = new StringTokenizer(rule,"->");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            String notLeftToken = this.negToken(leftToken); // negação do token da esquerda
            String notRightToken = this.negToken(rigthToken); // negação do token da direita

            if(facts.contains(notRightToken) || inferedFacts.contains(notRightToken)){
                System.out.println(rule+" - Modus Tolens");
                facts.addFact(notLeftToken);
                //return true;
            }
        }
        return false;
    }
}
