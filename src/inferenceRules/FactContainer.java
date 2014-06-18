package inferenceRules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by armando on 11/06/14.
 */
public class FactContainer {
    public HashSet<String> factList;
    public HashSet<String> specialFactList; // Gardará fatos variantes

    public FactContainer(){

        factList = new HashSet<String>();
        specialFactList = new HashSet<String>();
    }

    @Override
    public String toString(){
        return factList.toString();
    }

    public FactContainer addFact(String fact){
        this.factList.add(fact);
        return this;
    }

    public FactContainer removeFact(String fact){
        if(this.factList.contains(fact)){
            this.factList.remove(fact);
        }
        return this;
    }

    public FactContainer addFactList(List<String> factList){
        this.factList.addAll(factList);
        return this;
    }

    public FactContainer addSpecialFact(String specialFact){
       specialFactList.add(specialFact);
        return this;
    }

    public HashSet<String> getSpecialFactList(){
        return specialFactList;
    }

    public HashSet<String> getFactList() {
        return factList;
    }

    public boolean contains(String fact){
        return factList.contains(fact);
    }
    public boolean containsAll(FactContainer facts){ return factList.containsAll(facts.getFactList());}
}
