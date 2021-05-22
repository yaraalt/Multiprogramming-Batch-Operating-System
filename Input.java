

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Input 
{ public Queue<Job> jobs;	
public int count;	
int min;
int max;
int total;
int n; // number of jobs

	public Input() 
	{ jobs= new LinkedList<Job>();
	count= 0; 
	min= 256;
	max= 0;
	total= 0;
	n= (int)((Math.random()*(500 - 100) + 100)); }

	
	
	public Job generateJob() 
	{ int id= count++;
	int ecu= (int)((Math.random()*(512 - 16) + 16));
	int jobSize= (int)((Math.random()*(256 - 16) + 16));

	if(jobSize < min)
	min= jobSize;

	if(max < jobSize)
	max= jobSize;

	total += jobSize;
	Job obj= new Job(id, ecu, jobSize);
	return obj;  }



	public void generateInput() 
	{ File f= new File("Jobs.txt");
	FileOutputStream fOut;
	PrintWriter writer;
	
	try 
	{ fOut = new FileOutputStream(f);
	writer= new PrintWriter(fOut);  

	Job obj= null;
	for(int i= 0; i < n; i++) 
	{ obj= generateJob();
	writer.println(obj.jID + "\t" + obj.ECU + "\t" + obj.jobSize + "\n");  }

	writer.close();
	fOut.close(); } 
	catch (Exception e) 
	{ e.getMessage(); } } 



	public void fillJQueue() 
	{ File f= new File("Jobs.txt");
	Scanner input;
	
	try 
	{ input= new Scanner(f);

	Job obj;
	int id;
	int ecu;
	int size;
	while(input.hasNext()) 
	{ id= input.nextInt();
	ecu= input.nextInt();
	size= input.nextInt();
	obj= new Job(id, ecu, size);

	jobs.add(obj); } 

	input.close(); } 
	catch (Exception e) 
	{ e.getMessage(); } } }



