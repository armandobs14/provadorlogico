package inferenceRules;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by armando on 15/06/14.
 */
public class Absorption extends AbstractRule{

    @Override
    public boolean exec(String rule, FactContainer facts, ArrayList<String> sentences) {
        if(rule.contains("->")){
            StringTokenizer tokens = new StringTokenizer(rule,"->");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            if(facts.contains(leftToken)){
                StringBuilder builder = new StringBuilder();
                builder
                        .append(leftToken)
                        .append("->")
                        .append("(")
                        .append(leftToken)
                        .append("^")
                        .append(rigthToken)
                        .append(")");

                System.out.println(builder+" - Absorption");
                //return true;
            }
        }
        return false;
    }
}
