package org.semanticweb.HermiT.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.semanticweb.HermiT.Configuration;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.HermiT.Reasoner.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredDisjointClassesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;

public class Reasoning {

	public static void main(String[] args) throws Exception {
		OWLOntologyManager manager=OWLManager.createOWLOntologyManager();
        OWLDataFactory dataFactory=manager.getOWLDataFactory();
        File inputOntologyFile = new File("examples/ontologies/tp3.owl"); 
        OWLOntology ontology=manager.loadOntologyFromOntologyDocument(inputOntologyFile);
        
        IRI IOR = IRI.create("http://www.co-ode.org/ontologies/tp3.owl");
        
        //Verify if the ontology is consistent
        Reasoner reasoner=new Reasoner(ontology);
        System.out.println("Is the ontology created in Excise 2 consistent ? " + reasoner.isConsistent()); 
        
        //Do some reasoning tasks
        OWLClass doubleStu=dataFactory.getOWLClass(IRI.create(IOR+"#DoubleStu"));
    	OWLClass masterStu=dataFactory.getOWLClass(IRI.create(IOR+"#MasterStu"));
    	OWLAxiom axiom1 = dataFactory.getOWLSubClassOfAxiom(doubleStu, masterStu);
    	OWLAxiom axiom2 = dataFactory.getOWLSubClassOfAxiom(masterStu, doubleStu);
    	System.out.println("Does a double student is a master student ? " + reasoner.isEntailed(axiom1));
    	System.out.println("Does a master student is a double student ? " + reasoner.isEntailed(axiom2));
    	
    	OWLObjectProperty hasStudy=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#hasStudy"));
    	OWLClass Master = dataFactory.getOWLClass(IRI.create(IOR+"#Master"));
    	OWLClassExpression hasStudyMaster=dataFactory.getOWLObjectSomeValuesFrom(hasStudy, Master);
    	OWLAxiom axiom3 = dataFactory.getOWLSubClassOfAxiom(doubleStu, hasStudyMaster);  
        System.out.println("Does a double student have a study of master ? " + reasoner.isEntailed(axiom3));
        
        OWLClass masterDiploma=dataFactory.getOWLClass(IRI.create(IOR+"#MasterDiploma"));
    	OWLClass student=dataFactory.getOWLClass(IRI.create(IOR+"#Student"));
    	OWLClass masterDiplomaStu=dataFactory.getOWLClass(IRI.create(IOR+"#MasterDiplomaStu"));
    	OWLClass engineeringDiplomaStu=dataFactory.getOWLClass(IRI.create(IOR+"#EngineeringDiplomaStu"));
    	OWLObjectProperty hasDiploma=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#hasDiploma"));
    	OWLClassExpression hasDiplomaMaster=dataFactory.getOWLObjectSomeValuesFrom(hasDiploma, masterDiploma);
    	OWLClassExpression hasDiplomaMasterStu=dataFactory.getOWLObjectIntersectionOf(student, hasDiplomaMaster);
    	OWLAxiom axiom4 = dataFactory.getOWLSubClassOfAxiom(masterDiplomaStu, hasDiplomaMasterStu);
    	OWLAxiom axiom5 = dataFactory.getOWLSubClassOfAxiom(engineeringDiplomaStu, hasDiplomaMasterStu);
        OWLAxiom axiom6 = dataFactory.getOWLEquivalentClassesAxiom(masterDiplomaStu, hasDiplomaMasterStu);
    	System.out.println("Does a master diploma student have a diploma of master ? " + reasoner.isEntailed(axiom4));
    	System.out.println("Does a engineering diploma student have a diploma of master ? " + reasoner.isEntailed(axiom5));
    	System.out.println("Does a master diploma student is student who has a diploma of master ? " + reasoner.isEntailed(axiom6));
    	
    	//Student ⊓ ∃WorkIn.School  ⊑  Person ⊓ ∃WorkIn.School 
        OWLClass person=dataFactory.getOWLClass(IRI.create(IOR+"#Person"));
        OWLClass school=dataFactory.getOWLClass(IRI.create(IOR+"#School"));
    	OWLObjectProperty workIn=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#WorkIn"));
    	OWLClassExpression workInSchool=dataFactory.getOWLObjectSomeValuesFrom(workIn, school);
    	OWLClassExpression personWorkInSchool=dataFactory.getOWLObjectIntersectionOf(person, workInSchool);
    	OWLClassExpression studentWorkInSchool=dataFactory.getOWLObjectIntersectionOf(student, workInSchool);
    	OWLAxiom axiom7 = dataFactory.getOWLSubClassOfAxiom(studentWorkInSchool, personWorkInSchool);
    	System.out.println("Does a student work in school is a person work in school ? " + reasoner.isEntailed(axiom7));

    	//-------------------------------------------------------------------------------------
    	//Classify the ontology and save it
    	System.out.println("begin classify...");
        OWLOntologyManager manager1=OWLManager.createOWLOntologyManager();
        File inputOntologyFile1 = new File("examples/ontologies/tp3.owl");
        OWLOntology ontology1=manager1.loadOntologyFromOntologyDocument(inputOntologyFile1);
    	ReasonerFactory factory = new ReasonerFactory();
        Configuration c=new Configuration();
        c.reasonerProgressMonitor=new ConsoleProgressMonitor();
        OWLReasoner reasoner1=factory.createReasoner(ontology1, c);
        List<InferredAxiomGenerator<? extends OWLAxiom>> generators=new ArrayList<InferredAxiomGenerator<? extends OWLAxiom>>();
        generators.add(new InferredSubClassAxiomGenerator());
        generators.add(new InferredClassAssertionAxiomGenerator());
        generators.add(new InferredDisjointClassesAxiomGenerator() {
            boolean precomputed=false;
            protected void addAxioms(OWLClass entity, OWLReasoner reasoner, OWLDataFactory dataFactory, Set<OWLDisjointClassesAxiom> result) {
                if (!precomputed) {
                    reasoner.precomputeInferences(InferenceType.DISJOINT_CLASSES);
                    precomputed=true;
                }
                for (OWLClass cls : reasoner.getDisjointClasses(entity).getFlattened()) {
                    result.add(dataFactory.getOWLDisjointClassesAxiom(entity, cls));
                }
            }
        });
        InferredOntologyGenerator iog=new InferredOntologyGenerator(reasoner1,generators);
        OWLOntology inferredAxiomsOntology=manager1.createOntology();
        iog.fillOntology(manager1, inferredAxiomsOntology);
        File inferredOntologyFile=new File("examples/ontologies/tp3-inferred.owl");
        if (!inferredOntologyFile.exists())
            inferredOntologyFile.createNewFile();
        inferredOntologyFile=inferredOntologyFile.getAbsoluteFile();
        OutputStream outputStream=new FileOutputStream(inferredOntologyFile);
        manager1.saveOntology(inferredAxiomsOntology, manager1.getOntologyFormat(ontology1), outputStream);
        System.out.println("The ontology in examples/ontologies/tp3-inferred.owl should now contain all inferred axioms (you might need to refresh the IDE file view). ");
    	System.out.println("end classify");
    	
    	System.out.println(inferredAxiomsOntology);
	}
}
