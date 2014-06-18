package inferenceRules;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by armando on 11/06/14.
 */
public class Solver {
    private String sentence;
    private ArrayList<String> litteSentences = new ArrayList<String>();

    private FactContainer inferedFactContainer;
    private FactContainer initialFactContainer;

    private ArrayList<IRuleInference> rules;

    public Solver(String sentence){
        this.sentence = sentence;
        rules = new ArrayList<IRuleInference>();
    }

    public void generateFactBase(){
        //recebe uma conjunção de disjunções
        StringTokenizer tokens = new StringTokenizer(this.sentence,"^");

        String temp = new String();

        while(tokens.hasMoreTokens()){
            temp = tokens.nextToken().replace("(", "").replace(")","");
            if(temp.contains("->") || temp.contains("v") || temp.contains("^")){

                litteSentences.add(temp);
            }else if(temp.length() == 1){
                inferedFactContainer.addFact(temp);
                System.out.println(temp+" - Simplification");
            }
        }

        int i = 0;
        while(litteSentences.size() != 0 && i < litteSentences.size()){
            i++;
            for (int k = 0; k < rules.size(); k++) {
                if(i== 0) break;
                boolean success = rules.get(k).exec(litteSentences.get(i-1),this.initialFactContainer,this.inferedFactContainer, litteSentences);
                if(success){
                    //litteSentences.remove(i-1);
                    i = 0;
                }
            }
        }
    }

    public Solver addRule(IRuleInference rule){
        rules.add(rule);
        return this;
    }

    public void setInferedFactContainer(FactContainer factContainer){
        this.inferedFactContainer = factContainer;
    }

    public void setInitialFactContainer(FactContainer factContainer){
        this.initialFactContainer= factContainer;
    }

    public ArrayList<String> getLitteSentences(){
        return litteSentences;
    }
}
