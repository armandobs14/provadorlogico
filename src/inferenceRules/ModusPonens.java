package inferenceRules;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by armando on 10/06/14.
 */
public class ModusPonens extends AbstractRule{

    @Override
    public boolean exec(String rule, FactContainer facts,FactContainer inferedFacts, ArrayList<String> sentences) {
        if(rule.contains("->")){
            StringTokenizer tokens = new StringTokenizer(rule,"->");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            if(facts.contains(leftToken)){
                System.out.println(rule+" - Modus Ponens");
                inferedFacts.addSpecialFact(rigthToken);
                //return true;
            }
        }
        return false;
    }
}
