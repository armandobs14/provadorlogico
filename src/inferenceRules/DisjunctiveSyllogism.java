package inferenceRules;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by armando on 15/06/14.
 */
public class DisjunctiveSyllogism extends AbstractRule{
    @Override
    public boolean exec(String rule, FactContainer facts, ArrayList<String> senteces) {
        if(rule.contains("v")){
            StringTokenizer tokens = new StringTokenizer(rule,"v");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            String negatedLeftToken = this.negToken(leftToken); // negação do token da esquerda
            String negatedRightToken = this.negToken(leftToken); // negação do token da esquerda

            if(facts.contains(negatedLeftToken)){
                System.out.println(rule+" - Disjunctive Syllogism");
                facts.addFact(rigthToken);
                return true;
            }else if(facts.contains(negatedRightToken)){
                System.out.println(rule+" - Disjunctive Syllogism");
                facts.addFact(leftToken);
                return true;
            }
        }
        return false;
    }
}
