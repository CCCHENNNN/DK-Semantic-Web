package org.semanticweb.HermiT.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class CreatOntology {
	public static void main(String[] args) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
		
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLDataFactory dataFactory=manager.getOWLDataFactory();
		OWLOntology onto;
		IRI IOR = IRI.create("http://www.co-ode.org/ontologies/tp3.owl");
		onto = manager.createOntology(IOR);
		System.out.println(onto);
		
		//Create the classes(concepts)
		OWLClass Person = dataFactory.getOWLClass(IRI.create(IOR+"#Person"));
		OWLClass Student = dataFactory.getOWLClass(IRI.create(IOR+"#Student"));
		OWLClass EngineeringStu = dataFactory.getOWLClass(IRI.create(IOR+"#EngineeringStu"));
		OWLClass MasterStu = dataFactory.getOWLClass(IRI.create(IOR+"#MasterStu"));
		OWLClass DoubleStu = dataFactory.getOWLClass(IRI.create(IOR+"#DoubleStu"));
		OWLClass EngineeringDiplomaStu = dataFactory.getOWLClass(IRI.create(IOR+"#EngineeringDiplomaStu"));
		OWLClass MasterDiplomaStu = dataFactory.getOWLClass(IRI.create(IOR+"#MasterDiplomaStu"));
		OWLClass DoubleDiplomaStu = dataFactory.getOWLClass(IRI.create(IOR+"#DoubleDiplomaStu"));
		OWLClass QualifiedStu = dataFactory.getOWLClass(IRI.create(IOR+"#QualifiedStu"));
		OWLClass NonQualifiedStu = dataFactory.getOWLClass(IRI.create(IOR+"#NonQualifiedStu"));
		OWLClass Apprentice = dataFactory.getOWLClass(IRI.create(IOR+"#Apprentice"));
		OWLClass SchoolStaff = dataFactory.getOWLClass(IRI.create(IOR+"#SchoolStaff"));
		OWLClass Study = dataFactory.getOWLClass(IRI.create(IOR+"#Study"));
		OWLClass Engineering = dataFactory.getOWLClass(IRI.create(IOR+"#Engineering"));
		OWLClass Master = dataFactory.getOWLClass(IRI.create(IOR+"#Master"));
		OWLClass Diploma = dataFactory.getOWLClass(IRI.create(IOR+"#Diploma"));
		OWLClass EngineeringDiploma = dataFactory.getOWLClass(IRI.create(IOR+"#EngineeringDiploma"));
		OWLClass MasterDiploma = dataFactory.getOWLClass(IRI.create(IOR+"#MasterDiploma"));
		OWLClass Company = dataFactory.getOWLClass(IRI.create(IOR+"#Company"));
		OWLClass Course = dataFactory.getOWLClass(IRI.create(IOR+"#Course"));
		OWLClass School = dataFactory.getOWLClass(IRI.create(IOR+"#School"));
		
		//Create the roles
		OWLObjectProperty hasStudy=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#hasStudy"));
		OWLObjectProperty hasDiploma=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#hasDiploma"));
		OWLObjectProperty WorkIn=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#WorkIn"));
		OWLObjectProperty hasValidated=dataFactory.getOWLObjectProperty(IRI.create(IOR+"#hasValidated"));
		
		//Create the individuals
		OWLNamedIndividual ParisSaclay = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#ParisSaclay"));
		OWLNamedIndividual ParisSud = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#ParisSud"));
		OWLNamedIndividual Fan = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#Fan"));
		OWLNamedIndividual Chen = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#Chen"));
		OWLNamedIndividual Zhang = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#Zhang"));
		OWLNamedIndividual Xu = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#Xu"));
		OWLNamedIndividual SemanticWeb = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#SemanticWeb"));
		OWLNamedIndividual MachineLearning = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#MachineLearning"));
		OWLNamedIndividual BigData = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#BigData"));
		OWLNamedIndividual Orange = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#Orange"));
		OWLNamedIndividual Bouygues = dataFactory.getOWLNamedIndividual(IRI.create(IOR + "#Bouygues"));
		
		
		//Create the axioms
		OWLAxiom axiom1 = dataFactory.getOWLSubClassOfAxiom(EngineeringStu, Student);
		OWLAxiom axiom2 = dataFactory.getOWLSubClassOfAxiom(MasterStu, Student);
		OWLAxiom axiom3 = dataFactory.getOWLSubClassOfAxiom(DoubleStu, Student);
		OWLAxiom axiom4 = dataFactory.getOWLSubClassOfAxiom(EngineeringDiplomaStu, Student);
		OWLAxiom axiom5 = dataFactory.getOWLSubClassOfAxiom(MasterDiplomaStu, Student);
		OWLAxiom axiom6 = dataFactory.getOWLSubClassOfAxiom(DoubleDiplomaStu, Student);
		OWLAxiom axiom7 = dataFactory.getOWLSubClassOfAxiom(QualifiedStu, Student);
		OWLAxiom axiom8 = dataFactory.getOWLSubClassOfAxiom(Apprentice, Student);
		OWLAxiom axiom14 = dataFactory.getOWLSubClassOfAxiom(Engineering, Study);
		OWLAxiom axiom15 = dataFactory.getOWLSubClassOfAxiom(Master, Study);
		OWLAxiom axiom18 = dataFactory.getOWLSubClassOfAxiom(EngineeringDiploma, Diploma);
		OWLAxiom axiom19 = dataFactory.getOWLSubClassOfAxiom(MasterDiploma, Diploma);
		OWLAxiom axiom31 = dataFactory.getOWLSubClassOfAxiom(Student, Person);
		OWLAxiom axiom32 = dataFactory.getOWLSubClassOfAxiom(SchoolStaff, Person);
		
		//ABox
		//School(ParisSaclay)
		OWLClassAssertionAxiom axiom9 = dataFactory.getOWLClassAssertionAxiom(School, ParisSaclay);
		//School(ParisSud)
		OWLClassAssertionAxiom axiom10 = dataFactory.getOWLClassAssertionAxiom(School, ParisSud);
		//DoubleStu(Fan)
		OWLClassAssertionAxiom axiom11 = dataFactory.getOWLClassAssertionAxiom(DoubleStu,Fan);
		//DoubleStu(Chen)
		OWLClassAssertionAxiom axiom36 = dataFactory.getOWLClassAssertionAxiom(DoubleStu,Chen);
		//MasterStu(Zhang)
		OWLClassAssertionAxiom axiom37 = dataFactory.getOWLClassAssertionAxiom(MasterStu,Zhang);
		//MasterStu(Xu)
		OWLClassAssertionAxiom axiom38 = dataFactory.getOWLClassAssertionAxiom(MasterStu,Xu);
		//Course(SemanticWeb)
		OWLClassAssertionAxiom axiom33 = dataFactory.getOWLClassAssertionAxiom(Course, SemanticWeb);
		//Course(MachineLearning)
		OWLClassAssertionAxiom axiom34 = dataFactory.getOWLClassAssertionAxiom(Course, MachineLearning);
		//Course(BigData)
		OWLClassAssertionAxiom axiom35 = dataFactory.getOWLClassAssertionAxiom(Course, BigData);
		//Company(Orange)
		OWLClassAssertionAxiom axiom41 = dataFactory.getOWLClassAssertionAxiom(Company, Orange);
		//Company(Bouygues)
		OWLClassAssertionAxiom axiom42 = dataFactory.getOWLClassAssertionAxiom(Company, Bouygues);
		
		//hasValidated(Fan,MachineLearning)
		OWLObjectPropertyAssertionAxiom axiom39 = dataFactory.getOWLObjectPropertyAssertionAxiom(hasValidated, Fan, MachineLearning);
		//hasStudy(Fan,ParisSaclay)
		OWLObjectPropertyAssertionAxiom axiom40 = dataFactory.getOWLObjectPropertyAssertionAxiom(hasStudy, Fan, ParisSaclay);
		
		//TBox
		//Student = ∃hasStudy.School
		OWLClassExpression hasStudySchool=dataFactory.getOWLObjectSomeValuesFrom(hasStudy, School);
		OWLAxiom axiom12=dataFactory.getOWLEquivalentClassesAxiom(Student, hasStudySchool);
		
		//EngineeringStu = Student ⊓ ∃hasStudy.Engineering
		OWLClassExpression hasStudyEngineering=dataFactory.getOWLObjectSomeValuesFrom(hasStudy, Engineering);
		OWLClassExpression hasStudyEngineeringStu = dataFactory.getOWLObjectIntersectionOf(Student,hasStudyEngineering);
		OWLAxiom axiom13=dataFactory.getOWLEquivalentClassesAxiom(EngineeringStu, hasStudyEngineeringStu);
		
		//MasterStu = Students ⊓ ∃hasStudy.Master
		OWLClassExpression hasStudyMaster=dataFactory.getOWLObjectSomeValuesFrom(hasStudy, Master);
		OWLClassExpression hasStudyMasterStu = dataFactory.getOWLObjectIntersectionOf(Student,hasStudyMaster);
		OWLAxiom axiom16=dataFactory.getOWLEquivalentClassesAxiom(MasterStu, hasStudyMasterStu);
		
		//DoubleStu = Student ⊓ ∃hasStudy.Engineering ⊓ ∃hasStudy.Master
		OWLClassExpression hasStudyDouble=dataFactory.getOWLObjectIntersectionOf(hasStudyEngineering, hasStudyMaster);
		OWLClassExpression hasStudyDoubleStu = dataFactory.getOWLObjectIntersectionOf(Student,hasStudyDouble);
		OWLAxiom axiom17=dataFactory.getOWLEquivalentClassesAxiom(DoubleStu, hasStudyDoubleStu);
		
		//EngineeringDiplomaStu = Student ⊓ ∃hasDiploma.Engineering
		OWLClassExpression hasDiplomaEngineering=dataFactory.getOWLObjectSomeValuesFrom(hasDiploma, EngineeringDiploma);
		OWLClassExpression hasDiplomaEngineeringStu = dataFactory.getOWLObjectIntersectionOf(Student,hasDiplomaEngineering);
		OWLAxiom axiom20=dataFactory.getOWLEquivalentClassesAxiom(EngineeringDiplomaStu, hasDiplomaEngineeringStu);
		
		//MasterDiplomaStu = Students ⊓ ∃hasDiploma.Master
		OWLClassExpression hasDiplomaMaster=dataFactory.getOWLObjectSomeValuesFrom(hasDiploma, MasterDiploma);
		OWLClassExpression hasDiplomaMasterStu = dataFactory.getOWLObjectIntersectionOf(Student,hasDiplomaMaster);
		OWLAxiom axiom21=dataFactory.getOWLEquivalentClassesAxiom(MasterDiplomaStu, hasDiplomaMasterStu);
		
		//DoubleDiplomaStu = Student ⊓ ∃hasDiploma.Engineering ⊓ ∃hasDiploma.Master
		OWLClassExpression hasDiplomaDouble=dataFactory.getOWLObjectIntersectionOf(hasDiplomaEngineering, hasDiplomaMaster);
		OWLClassExpression hasDiplomaDoubleStu = dataFactory.getOWLObjectIntersectionOf(Student,hasDiplomaDouble);
		OWLAxiom axiom22=dataFactory.getOWLEquivalentClassesAxiom(DoubleDiplomaStu, hasDiplomaDoubleStu);
		
		//Apprentice = Student ⊓ ∃WorkIn.Enterprise
		OWLClassExpression WorkInCompany=dataFactory.getOWLObjectSomeValuesFrom(WorkIn, Company);
		OWLClassExpression WorkInCompanyStu = dataFactory.getOWLObjectIntersectionOf(Student,WorkInCompany);
		OWLAxiom axiom27=dataFactory.getOWLEquivalentClassesAxiom(Apprentice, WorkInCompanyStu);
		
		//QualifiedStu = student ⊓ 12 ≤ hasValidated.Course
		OWLClassExpression hasValidatedCourse = dataFactory.getOWLObjectMinCardinality(12, hasValidated, Course);
		OWLClassExpression hasValidatedStu = dataFactory.getOWLObjectIntersectionOf(Student,hasValidatedCourse);
		OWLAxiom axiom28=dataFactory.getOWLEquivalentClassesAxiom(QualifiedStu, hasValidatedStu);
		
		//NonQualifiedStu = student ⊓ ¬12 ≤ hasValidated.Course
		OWLClassExpression hasNoValidatedCourse = dataFactory.getOWLObjectComplementOf(hasValidatedCourse);
		OWLClassExpression hasNoValidatedStu = dataFactory.getOWLObjectIntersectionOf(Student,hasNoValidatedCourse);
		OWLAxiom axiom29=dataFactory.getOWLEquivalentClassesAxiom(NonQualifiedStu, hasNoValidatedStu);
		
		//SchoolStaff = Person ⊓ WorkIn.School ⊓ ¬Student
		OWLClassExpression WorkInSchool = dataFactory.getOWLObjectSomeValuesFrom(WorkIn, School);
		OWLClassExpression WorkInSchoolStaff = dataFactory.getOWLObjectIntersectionOf(Person,WorkInSchool);
//		OWLClassExpression noStudent = dataFactory.getOWLObjectComplementOf(Student);
//		OWLClassExpression WorkInSchoolStaffNoStudent = dataFactory.getOWLObjectIntersectionOf(noStudent,WorkInSchoolStaff);
//		OWLAxiom axiom30=dataFactory.getOWLEquivalentClassesAxiom(SchoolStaff, WorkInSchoolStaffNoStudent);
		OWLAxiom axiom30=dataFactory.getOWLEquivalentClassesAxiom(SchoolStaff, WorkInSchoolStaff);
		
		//Add the axioms into the ontology
		manager.addAxiom(onto, axiom1);
		manager.addAxiom(onto, axiom2);
		manager.addAxiom(onto, axiom3);
		manager.addAxiom(onto, axiom4);
		manager.addAxiom(onto, axiom5);
		manager.addAxiom(onto, axiom6);
		manager.addAxiom(onto, axiom7);
		manager.addAxiom(onto, axiom8);
		manager.addAxiom(onto, axiom9);
		manager.addAxiom(onto, axiom10);
		manager.addAxiom(onto, axiom11);
		manager.addAxiom(onto, axiom12);
		manager.addAxiom(onto, axiom13);
		manager.addAxiom(onto, axiom14);
		manager.addAxiom(onto, axiom15);
		manager.addAxiom(onto, axiom16);
		manager.addAxiom(onto, axiom17);
		manager.addAxiom(onto, axiom18);
		manager.addAxiom(onto, axiom19);
		manager.addAxiom(onto, axiom20);
		manager.addAxiom(onto, axiom21);
		manager.addAxiom(onto, axiom22);
//		manager.addAxiom(onto, axiom23);
//		manager.addAxiom(onto, axiom24);
//		manager.addAxiom(onto, axiom25);
//		manager.addAxiom(onto, axiom26);
		manager.addAxiom(onto, axiom27);
		manager.addAxiom(onto, axiom28);
		manager.addAxiom(onto, axiom29);
		manager.addAxiom(onto, axiom30);
		manager.addAxiom(onto, axiom31);
		manager.addAxiom(onto, axiom32);
		manager.addAxiom(onto, axiom33);
		manager.addAxiom(onto, axiom34);
		manager.addAxiom(onto, axiom35);
		manager.addAxiom(onto, axiom36);
		manager.addAxiom(onto, axiom37);
		manager.addAxiom(onto, axiom38);
		manager.addAxiom(onto, axiom39);
		manager.addAxiom(onto, axiom40);
		manager.addAxiom(onto, axiom41);
		manager.addAxiom(onto, axiom42);
		
		
		//Save the ontology to a file
		OutputStream outputStream=new FileOutputStream("examples/ontologies/tp3.owl");
        manager.saveOntology(onto, outputStream);
        System.out.println(onto);
        
//        for(OWLAxiom axiom : onto.getAxioms()){
//        	System.out.println(axiom);
//        }
    }
}
