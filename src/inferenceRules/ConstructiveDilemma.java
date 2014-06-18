package inferenceRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by armando on 15/06/14.
 */
public class ConstructiveDilemma extends AbstractRule{
    private HashMap<String,String> privateMap;

    public ConstructiveDilemma(){
        privateMap = new HashMap<String, String>();
    }

    @Override
    public boolean exec(String rule, FactContainer factContainer, FactContainer inferedFactContainer, ArrayList<String> sentences) {
        if(rule.contains("->")){
            StringTokenizer tokens = new StringTokenizer(rule,"->");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            privateMap.put(leftToken,rigthToken);
        }else if(rule.contains("v")){
            StringTokenizer tokens = new StringTokenizer(rule,"v");

            String leftToken = tokens.nextToken(); // lado esquerdo
            String rigthToken = tokens.nextToken(); // lado direito

            if(privateMap.containsKey(leftToken) && privateMap.containsKey(rigthToken)){
                String tk1 = privateMap.get(leftToken);
                String tk2 = privateMap.get(rigthToken);

                StringBuilder builder = new StringBuilder();
                builder
                        .append(tk1)
                        .append("v")
                        .append(tk2);

                System.out.println(builder+" - Constructive Dilemma");
            }
        }
        return false;
    }
}
