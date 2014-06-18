package inferenceRules;

import java.util.ArrayList;

/**
 * Created by armando on 10/06/14.
 */
public interface IRuleInference {
    public boolean exec(String rule, FactContainer factContainer, FactContainer inferedFacts, ArrayList<String> sentences);
}
