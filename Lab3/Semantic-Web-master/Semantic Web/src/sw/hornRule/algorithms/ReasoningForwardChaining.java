/**
 * 
 */
package sw.hornRule.algorithms;

import sw.hornRule.models.FactBase;
import sw.hornRule.models.Formalism;
import sw.hornRule.models.HornRule;
import sw.hornRule.models.HornRuleBase;
import sw.hornRule.models.Variable;

/*
 *  @author  <Wafa Djerad>
 */
public class ReasoningForwardChaining extends AlogrithmChaining {
 
	private FactBase myFactBase;
	private HornRuleBase myRuleBase;

	
	public FactBase forwardChaining(Formalism ruleBase, Formalism factBase){
		
		this.myFactBase = (FactBase) factBase;
		this.myRuleBase = (HornRuleBase) ruleBase;
		
			for ( HornRule a : myRuleBase.getRules()){
				if (eval( a , myFactBase)){
					for (Variable concl : a.getConclusions()){
						myFactBase.getFact().add(concl);
						//System.out.println(myFactBase);
					}
				}
		}
		return myFactBase;
	};
	

	public boolean entailment(Formalism ruleBase, Formalism factBase, Formalism query) {
		FactBase allInferredFacts = forwardChaining(ruleBase, factBase);
		if(match((Variable)query, allInferredFacts))
			return true;
		else
			return false;
	}
	
	public boolean eval (HornRule ruleBase, FactBase factBase){
		
		for ( Variable cond : ruleBase.getConditions()){
				if (match(cond, factBase)){
					continue;
				} else {
				return false;
			}
			}
		return true;
	}
	
	public boolean match( Variable condition, FactBase factBase){
		

		for ( Variable fact:factBase.getFact()){
			if ( fact.toString().contentEquals(condition.toString())){
				return true;
			} 
		}
		return false;
	}


	public int countNbMatches(Formalism ruleBase, Formalism factBase) {
		// TODO Auto-generated method stub
		int i =0;
			for ( HornRule a : myRuleBase.getRules()){
				for ( Variable cond : a.getConditions()){
					if (match(cond, (FactBase)factBase)){
						i++;
					}
				}	
		}
		return i;
	}
}
