package com.chaos.Gpacl;

import static com.chaos.Gpacl.Constant.FIRST_COLUMN;
import static com.chaos.Gpacl.Constant.SECOND_COLUMN;
import static com.chaos.Gpacl.Constant.THIRD_COLUMN;
import static com.chaos.Gpacl.Constant.FOURTH_COLUMN;
import static com.chaos.Gpacl.Constant.FIFTH_COLUMN;


import java.util.ArrayList;
import java.util.HashMap;
import androidx.appcompat.widget.Toolbar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.*;
import android.view.*;
import android.content.*;
import androidx.appcompat.widget.*;
import androidx.appcompat.app.*;
import java.io.*;

/**
 * 
 * @author Paresh N. Mayani
 * http://pareshnmayani.wordpress.com
 */
public class Result_Activity extends AppCompatActivity 
{
  private ArrayList<HashMap<String,String>> list;
  private ArrayList<HashMap<String,String>> list2;
  Toolbar tool;

  ArrayList<String> letterGrade = new ArrayList<String>();
  ArrayList<Double> numberGrade= new ArrayList<Double>();
  ArrayList<Double> gradePoint = new ArrayList<Double>();
  ArrayList<Double> grade= new ArrayList<Double>();
  ArrayList<Integer> credit= new ArrayList<Integer>();
  double GPA;
  String alG;
  double sumGp;
  int sumcredit;
  int privCredit;
  double privGPA;
  double privSumGp;
  int remark;
  int pass;
  int x ;
  int y,m;
  String CumAlg;
  ArrayList<Double> prevGPA = new ArrayList<Double>();
  ArrayList<Integer> prevCredit = new ArrayList<Integer>();
  ArrayList<Double> prevSumGP = new ArrayList<Double>();
  ArrayList<String> ALG = new ArrayList<String>();
  String[] Remark = new String[12];

  private String temp;
  String hold;
  int hol;
  public void onCreate(Bundle savedInstanceState) 
  {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.result_set);

	tool = findViewById(R.id.result_setinclude);
	tool.setTitle("Grade Report");
	setSupportActionBar(tool);

	Intent intent = getIntent();
	hol = intent.getStringArrayListExtra("grade").size();
	for(int i =0;i<hol;i++){
	  grade.add(Double.valueOf(intent.getStringArrayListExtra("grade").get(i)));
	}for(int i=0;i<hol;i++){
	  credit.add(intent.getIntegerArrayListExtra("credit").get(i));
	}



	setLetterGrade();
	setGradePoint();
	setANG();
	setALG();
	preSemester();
	pre();
	CumALG();
	addToRemark();
    serializer();
	deSerializer();

	ListView lview = findViewById(R.id.resultsetListView1);
	populateList();
	listviewAdapter adapter = new listviewAdapter(this, list);
	lview.setAdapter(adapter);
	ListView lview2 = findViewById(R.id.resultsetListView2);
	populateListTow();
	listviewAdapter adapter2 = new listviewAdapter(this, list2);
	lview2.setAdapter(adapter2);




  }    



  private void populateList() {
	//  
	list = new ArrayList<HashMap<String,String>>();

	HashMap<String,String> tem= new HashMap<String,String>();
	tem.put(FIFTH_COLUMN,"Cours Mark");
	tem.put(FIRST_COLUMN, "Credit");
	tem.put(SECOND_COLUMN, "Number Grade");
	tem.put(THIRD_COLUMN, "Letter Grade");
	tem.put(FOURTH_COLUMN, "Grade Point");
	list.add(tem);

	for(int i=0;i<numberGrade.size();i++){
	  temp ="temp" + i;
	  HashMap<String,String> temp = new HashMap<String,String>();
	  temp.put(FIFTH_COLUMN,String.valueOf(grade.get(i)));
	  temp.put(FIRST_COLUMN, String.valueOf(credit.get(i)));
	  temp.put(SECOND_COLUMN, String.valueOf(numberGrade.get(i)));
	  temp.put(THIRD_COLUMN, letterGrade.get(i));
	  temp.put(FOURTH_COLUMN, String.valueOf(gradePoint.get(i)));
	  list.add(temp);
	}
  }

  private void populateListTow(){

	list2 = new ArrayList<HashMap<String,String>>(); 
	int i=0;
	HashMap<String,String> temp = new HashMap<String,String>();
	temp.put(FIFTH_COLUMN,"Privous Total");
	temp.put(FIRST_COLUMN, String.valueOf(prevCredit.get(i)));
	temp.put(SECOND_COLUMN, String.valueOf(prevSumGP.get(y)));
	temp.put(THIRD_COLUMN, String.valueOf(prevGPA.get(y)));
	temp.put(FOURTH_COLUMN, String.valueOf(ALG.get(y)));
	list2.add(temp);

	HashMap<String,String> temp1 = new HashMap<String,String>();
	temp1.put(FIFTH_COLUMN,"Semester Total");
	temp1.put(FIRST_COLUMN, String.valueOf(sumcredit));
	temp1.put(SECOND_COLUMN, String.valueOf(sumGp));
	temp1.put(THIRD_COLUMN, String.valueOf(GPA));
	temp1.put(FOURTH_COLUMN, alG);
	list2.add(temp1);

	HashMap<String,String> temp2= new HashMap<String,String>();
	temp2.put(FIFTH_COLUMN," Cumulative ");
	temp2.put(FIRST_COLUMN, String.valueOf(privCredit));
	temp2.put(SECOND_COLUMN, String.valueOf(privSumGp));
	temp2.put(THIRD_COLUMN, String.valueOf(privGPA));
	temp2.put(FOURTH_COLUMN, CumAlg);
	list2.add(temp2);


  }




  void setLetterGrade() {


	for (int i = 0; i < grade.size(); i++) {
	  if ((grade.get(i) <= 100) && (grade.get(i) >= 90)) {
		letterGrade.add(i,"A+");
		numberGrade.add(i,4d);
	  } else if ((grade.get(i) < 90) && (grade.get(i) >= 85)) {
		letterGrade.add(i,"A");
		numberGrade.add(i, 4d);
	  } else if ((grade.get(i) < 85) && (grade.get(i) >= 80)) {
		letterGrade.add(i,"A-");
		numberGrade.add(i,3.75d);
	  } else if ((grade.get(i) < 80) && (grade.get(i) >= 75)) {
		letterGrade.add(i,"B+");
		numberGrade.add(i, 3.5);
	  } else if ((grade.get(i) < 75) && (grade.get(i) >= 70)) {
		letterGrade.add(i,"B");
		numberGrade.add(i, 3d);
	  } else if ((grade.get(i) < 70) && (grade.get(i) >= 65)) {
		letterGrade.add(i,"B-");
		numberGrade.add(i,2.75d);
	  } else if ((grade.get(i) < 65) && (grade.get(i) >= 60)) {
		letterGrade.add(i,"C+");
		numberGrade.add(i, 2.5d);
	  } else if ((grade.get(i) < 60) && (grade.get(i) >= 50)) {
		letterGrade.add(i,"C");
		numberGrade.add(i, 2d);
	  } else if ((grade.get(i) < 50) && (grade.get(i) >= 40)) {
		letterGrade.add(i,"D");
		numberGrade.add(i, 1d);;
	  } else  {
		letterGrade.add(i,"F");
		numberGrade.add(i, 0d);
	  }
	}
  }
//Method
  void setGradePoint() {
	double h;
	for (int i = 0; i < grade.size(); i++) {
	  gradePoint.add(i,credit.get(i)* numberGrade.get(i));
	  //	gradePoint.add(i,h);
	}

	for (int i = 0; i < grade.size(); i++) {
	  sumGp += gradePoint.get(i);
	  sumcredit += credit.get(i);
	}
  }
  //Method
  void setANG() {
	GPA = sumGp / sumcredit;
	GPA=Math.round(GPA *100.0)/100.0;
  }
  void preSemester() {
	prevGPA.add(GPA);
	prevCredit.add(sumcredit);
	prevSumGP.add(sumGp);
	ALG.add(alG);
  }
  //Method

  void pre() {
	if (x > 0) {
	  for (double b : prevGPA) {
		privGPA += b;
	  }
	  privGPA = privGPA / prevGPA.size();

	  for (int c : prevCredit)
		privCredit += c;

	  for (double e : prevSumGP){
		privSumGp += e;}

	} else if (x <= 0) {
	  privCredit = sumcredit;
	  privGPA = GPA;
	  privSumGp = sumGp;
	  privSumGp=sumGp;
	}
	x++;
  }
  void reset() {

	GPA = 0;
	sumcredit = 0;
	alG = "";
	CumAlg="";
	sumGp = 0;
	privCredit =0;
	privGPA = 0;
	privSumGp = 0;
  }
//Method
  void setALG() {
	if (GPA == 4)
	  alG = "A";
	else if (GPA<4 & GPA >= 3.75)
	  alG = "A-";
	else if (GPA<3.75 & GPA >= 3.5)
	  alG = "B+";
	else if (GPA<3.5 & GPA >= 3)
	  alG = "B";
	else if (GPA<3 & GPA >= 2.75)
	  alG = "B-";
	else if (GPA<2.75 & GPA >= 2.5)
	  alG = "C+";
	else if (GPA<2.5 & GPA >= 2)
	  alG = "C";
	else if (GPA<2 & GPA >= 1.75)
	  alG = "C-";
	else if (GPA<1.75 & GPA >= 1)
	  alG = "D";
	else  alG = "F";
  }

  void CumALG() {

	if (privGPA  == 4){
	  CumAlg = "A";
	  remark=1;}
	else if (privGPA <4 & privGPA  >= 3.75){
	  CumAlg = "A-";
	  remark=1;}
	else if (privGPA <3.75 & privGPA  >= 3.5){
	  CumAlg = "B+";
	  remark=2;}
	else if (privGPA <3.5 & privGPA  >= 3){
	  CumAlg = "B";
	  remark=2;}
	else if (privGPA <3 & privGPA  >= 2.75){
	  CumAlg = "B-";
	  remark=3;}
	else if (privGPA <2.75 & privGPA  >= 2.5){
	  CumAlg = "C+";
	  remark=4;}
	else if (privGPA <2.5 & privGPA  >= 2){
	  CumAlg = "C";
	  remark=5;}
	else if (privGPA <2 & privGPA  >= 1.75){
	  CumAlg = "C-";
	  remark=5;}
	else if (privGPA <1.75 & privGPA >= 1){
	  CumAlg = "D";
	  remark=6;}
	else if(privGPA <1){
	  CumAlg = "F";
	  remark=6;}
  }
  void addToRemark(){	
	Remark[0]="\t  Remark";
	Remark[1]="\tFirst Class with grate Distinction ";
	Remark[2]="\tFirst Class With Distinction ";
	Remark[3]="\tFirst Class";
	Remark[4]="\tScond Class ";
	Remark[5]="\tLower Class ";
	Remark[6]="\tLowest Class ";
	Remark[7]="\t  Pass";
	Remark[8]="\tAcadamic Warnig ";
	Remark[9]="\tForced withdrawal";
	Remark[10]="\tAcadamic Dismissal";
	Remark[11]="\tComplete Acadamic Dismissal";
	if(remark<=5)
	  pass=7;
	else if(remark==6)
	  pass=8;
	else if(remark>=7)
	  pass=9;
  }


  public void serializer(){
   
	try
	{
	  FileOutputStream fos = new FileOutputStream("report");
	  try
	  {
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(prevSumGP);
		oos.writeObject(prevCredit);
		oos.writeObject(prevGPA);
		oos.writeObject(ALG);
		oos.close();
		fos.close();
	  }
	  catch (IOException e)
	  {}
	}
	catch (FileNotFoundException e)
	{}
  }

  public void deSerializer(){
	
	try
	{
	  FileInputStream fis = new FileInputStream("report");
	  try
	  {
		ObjectInputStream ois = new ObjectInputStream(fis);
		try
		{
		  prevSumGP = (ArrayList<Double>) ois.readObject();
		  //prevGPA = (ArrayList<Double>) ois.readObject();
		}
		catch (IOException e)
		{}
		catch (ClassNotFoundException e)
		{}
	  }
	  catch (IOException e)
	  {}
	}
	catch (FileNotFoundException e)
	{}

	
  }
  
  
}
