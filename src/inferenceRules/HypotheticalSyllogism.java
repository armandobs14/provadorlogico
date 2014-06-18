package inferenceRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by armando on 15/06/14.
 */
public class HypotheticalSyllogism extends AbstractRule{
    private HashMap<String,String> implicatedByMap;
    private HashMap<String,String> implicatedTokens;
    public HypotheticalSyllogism(){
        this.implicatedByMap = new HashMap<String, String>();
    }

    @Override
    public boolean exec(String rule, FactContainer factContainer,FactContainer inderedFactContainer, ArrayList<String> sentences) {
        if(rule.contains("->")){
            StringTokenizer tokens = new StringTokenizer(rule,"->");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            if(!implicatedByMap.containsKey(leftToken)){
                implicatedByMap.put(rigthToken, leftToken);
            }else{
                String token = implicatedByMap.get(leftToken);
                StringBuilder builder= new StringBuilder();
                builder.append(token)
                        .append("->")
                        .append(rigthToken);

                inderedFactContainer.addSpecialFact(leftToken); // Exibindo tokens inferidos


                inderedFactContainer.addFact(token);

                sentences.remove(token+"->"+leftToken);
                sentences.remove(leftToken+"->"+rigthToken);
                sentences.add(token+"->"+rigthToken);

                implicatedByMap.put(rigthToken, token);

                System.out.println(builder.toString()+" - Hypothetical Syllogism");
                return true;
            }

        }
        return false;
    }
}
