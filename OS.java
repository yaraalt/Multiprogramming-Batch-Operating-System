

import java.io.File;
import java.io.FileWriter;
import java.util.*;



public class OS 
{ double hdSize = (int) 2E6; // in KB
double ramSize = (int) 192E3; // in KB
Queue<PCB> ready = new LinkedList<>();
PriorityQueue<Job> jobs;
Input input;

int n; // number of jobs
int max;
int min;
int total;

	

	public OS() 
	{ System.out.println("\t-- Simulation intialized -- \n");
	
	input = new Input();
	input.generateInput();
	input.fillJQueue();
	max = input.max;
	min = input.min;
	total = input.total;
	n = input.n;
	jobs = new PriorityQueue<>(n, new JobComparator());
		
	System.out.printf("\t-- %d Jobs generated -- \n\n", n);
	System.out.printf("\t-- Total required memory: %d KB -- \n\n\t-- RAM = %d KB --\n\n", total, (int) ramSize); }


	
	public void JobScheduler() 
	{ if(input.jobs.size() > 0) 
	{ System.out.println("\t-- Filling Job Queue -- \n");
	
	while(hdSize > 0 && input.jobs.size() > 0) 
	{ Job obj= input.jobs.poll();
	jobs.add(obj);
	
	hdSize -= obj.jobSize; }
	
	System.out.printf("\t-- %d job/s in the Job Queue -- \n\n", jobs.size()); } }

	

	public Queue<PCB> CPUScheduler() 
	{ JobScheduler();

	if(jobs.size() > 0) 
	{ System.out.println("\t-- Filling Ready Queue --\n");
	
	while(jobs.size() > 0 && ramSize > 0) 
	{ Job j = jobs.poll();
	PCB p = new PCB(j.jID, j.ECU, j.jobSize);
	p.admit(); // process state = ready
	ready.add(p);
	
	hdSize += j.jobSize;
	ramSize -= j.jobSize; }
	
	System.out.printf("\t-- %d Process/es are in the Ready Queue -- \n\n", ready.size()); } 
	

	return ready; }
	
	
	
	public void generateOutput(int normal, int abnormal) 
	{ File f= new File("Results.txt");

	try 
	{ FileWriter fw = new FileWriter(f);
	double avg= 0;
	
	if(n != 0)
	avg = total/n;

	fw.write("The total number of jobs processed  " + (normal + abnormal) + " from a total of " + n + ".\n"); 
	fw.write("The number of jobs that completed normally  " + normal + ".\n");
	fw.write("The number of jobs that completed abnormally  " + abnormal + ".\n");
	fw.write("The maximum job size is  " + max + "KB. \n");
	fw.write("The minimum job size is  " + min + "KB. \n");
	fw.write("The average job size is  " + avg + "KB. \n");

	fw.close(); } 
	catch(Exception e) 
	{ e.getMessage(); } } }


