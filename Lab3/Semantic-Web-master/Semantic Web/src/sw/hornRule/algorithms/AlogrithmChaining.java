package sw.hornRule.algorithms;

import sw.hornRule.models.FactBase;
import sw.hornRule.models.Formalism;
import sw.hornRule.models.HornRule;
import sw.hornRule.models.HornRuleBase;
import sw.hornRule.models.Variable;

/**
 * @author Yue Ma
 *
 */
public abstract class AlogrithmChaining implements Reasoner{
	
	protected int nbMatches; // le nombre de match(l,BF)
	
	public AlogrithmChaining() {
		this.nbMatches = 0;
	}

	public int getNbMatches() {
		return nbMatches;
	}
	
	
	public boolean entailment(Formalism ruleBase, Formalism factBase, Formalism query){
		FactBase fBase = (FactBase) factBase;
		HornRuleBase rule = (HornRuleBase) ruleBase;
		boolean verif = false;
			for ( HornRule a : rule.getRules()){
				for (Variable condition : a.getConditions()){
					
					if (match(condition, fBase))
						verif = true;
					else {
						verif = false; 
						break;
					}  
				}
			
			
					if (verif = true )
						return true;
					if (verif == false)
						continue;
				}
			return verif;
			}
		
	
	
						
	
	/**
	 * return true iff ruleBase U factBase is consistent, iff (ruleBase U factBase) |= False
	 */
	public boolean consistent(Formalism ruleBase, Formalism factBase){
		if(entailment(ruleBase, factBase, Variable.False))
			return true;	
		else 
			return false;
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
		
		HornRuleBase rule = (HornRuleBase) ruleBase;
		int i =0;
		for ( HornRule a : rule.getRules()){
			for ( Variable cond : a.getConditions()){
				if (match(cond, (FactBase)factBase)){
					i++;
				}
			}	
	}
	return i;
	}
}
