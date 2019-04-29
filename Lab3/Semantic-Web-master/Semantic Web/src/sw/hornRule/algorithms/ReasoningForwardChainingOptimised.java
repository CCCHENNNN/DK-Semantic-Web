/**
 * 
 */
package sw.hornRule.algorithms;

import java.util.HashSet;
import java.util.Iterator;

import sw.hornRule.models.FactBase;
import sw.hornRule.models.Formalism;
import sw.hornRule.models.HornRule;
import sw.hornRule.models.HornRuleBase;
import sw.hornRule.models.Variable;

/*
 *  @author  <Wafa Djerad>
 */
public class ReasoningForwardChainingOptimised extends AlogrithmChaining {
	
	public FactBase forwardChainingOptimise(HornRuleBase ruleBase, FactBase factBase){

		FactBase factBaseBis;
		for ( Variable fact:((FactBase) factBase).getFact()){
			factBaseBis = propagate(ruleBase, fact);
		}
		return (FactBase) factBase;
	};
	
	public FactBase propagate (HornRuleBase ruleBase, Variable fact){
		
		FactBase factBaseNew = new FactBase();
		HornRuleBase rules = new HornRuleBase();
		Iterator<HornRule> myRule = rules.getRules().iterator();

		while (myRule.hasNext()) {
			HornRule rule = myRule.next();
			HornRule rule2;
			
			rule2 = rule;
			Iterator<Variable> it =rule2.getConditions().iterator();
			
			while (it.hasNext()){
				Variable condFacts = it.next();
				if (rule2.toString().contentEquals(condFacts.toString())) {
					it.remove();
					}
				}
			
			Iterator<Variable> facts =rule2.getConclusions().iterator();
			factBaseNew.setFact((HashSet<Variable>) facts);
			}
		return factBaseNew;
	}
 
	public boolean entailment(Formalism ruleBase, Formalism factBase, Formalism query) {
		FactBase allInferredFacts = forwardChainingOptimise((HornRuleBase)ruleBase, (FactBase)factBase);
		if(allInferredFacts.getFact().contains(query))
			return true;
		else
			return false;
	}

	@Override
	public int countNbMatches(Formalism ruleBase, Formalism factBase) {
		// TODO Auto-generated method stub
		return 0;
	}

}
