/**
 * 
 */
package sw.hornRule.algorithms;

import java.util.HashSet;

import sw.hornRule.models.FactBase;
import sw.hornRule.models.Formalism;
import sw.hornRule.models.HornRule;
import sw.hornRule.models.HornRuleBase;
import sw.hornRule.models.Variable;

/*
 *  @author  <Wafa Djerad>
 */
public class ReasoningBackwardChaining extends AlogrithmChaining {
	
	public FactBase fb;
	public HornRuleBase rb;
	public Variable q;
	FactBase conclusion = new FactBase();

 

	public boolean entailment(Formalism ruleBase, Formalism factBase, Formalism query) {
		return backwardChaining(ruleBase,factBase,query);
	}

	public boolean backwardChaining(Formalism ruleBase, Formalism factBase,
			Formalism query) {
		this.fb = (FactBase) factBase;
		this.rb = (HornRuleBase) ruleBase;
		this.q = (Variable) query;

		if (match(q,fb)){
			return true;
		} else {
			for ( HornRule a : rb.getRules()){
				for (Variable cond : a.getConditions()){
					for (Variable concl : a.getConclusions()){
						fb.getFact().add(concl);
						}
					if (match(q,fb)){
						boolean t = true; int i = 1;
						
						while ( t =true && i<= nbMatches){
							backwardChaining(rb, fb, a);
							i = i+1;
							}
						if (t == true) {
							return t;
							}
						}
					}
				}
		}return false;
	}
	
	public boolean match( Variable query, FactBase factBase){
		for ( Variable fact:factBase.getFact()){
			if ( fact.toString().contentEquals(query.toString())){
				return true;
			} 
		}
		return false;
	}

	@Override
	public int countNbMatches(Formalism ruleBase, Formalism factBase) {
		int i =0;
		
		for ( HornRule a : rb.getRules()){
			for (Variable concl : a.getConclusions()){
				fb.getFact().add(concl);
				if (match(q,fb)){
					i++;
				}
			}	
	}
	return i;
	}

}
