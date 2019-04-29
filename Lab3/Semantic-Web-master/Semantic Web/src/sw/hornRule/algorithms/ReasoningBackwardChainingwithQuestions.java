/**
 * 
 */
package sw.hornRule.algorithms;
import java.util.Scanner;

import sw.hornRule.models.FactBase;
import sw.hornRule.models.Formalism;
import sw.hornRule.models.HornRule;
import sw.hornRule.models.HornRuleBase;
import sw.hornRule.models.Variable;

/*
 *  @author  <Wafa Djerad>
 */
public class ReasoningBackwardChainingwithQuestions extends AlogrithmChaining {

	public FactBase fb;
	public HornRuleBase rb;
	public Variable Q;
	FactBase conclusion = new FactBase();
	
	@Override
	public boolean entailment(Formalism ruleBase, Formalism factBase, Formalism query) {
		return backwardChaining(ruleBase,factBase,query);
	}

	public boolean backwardChaining(Formalism ruleBase, Formalism factBase,
			Formalism query) {
		
		this.fb = (FactBase) factBase;
		this.rb = (HornRuleBase) ruleBase;
		this.Q = (Variable) query;
		

		if (match(Q,fb)){
			return true;
		} else {
			for ( HornRule a : rb.getRules()){
				for (Variable cond : a.getConditions()){
					for (Variable concl : a.getConclusions()){
						fb.getFact().add(concl);
				}
				if (match(Q,fb)){
					boolean t = true;
					int i = 1;
					while ( t =true && i<= nbMatches){
	
						backwardChaining(rb, fb,cond);
						i = i+1;
					} if (t == true) {
						return t;
					}
					
				} else {
					String ans=demandableQ("the query is "+Q);
					if(question(ans))
						return true;
					else
						return false;
				}
			} return false;
		} }
		return false;
	}
	
	public String demandableQ (String Q) {
	     Scanner scan = new Scanner(System.in); 
	     System.out.println("is the query true ?"); 
	     String input = scan.nextLine();
	    
		return input;
	}

	
	public boolean question(String ques){
		if ( ques.contentEquals("yes") )
			return true;
		else 
			return false;
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
		// TODO To complete
		return 0;
	}

}
