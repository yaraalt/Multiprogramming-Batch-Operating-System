


public class Job
{ public int jID;
public int jobSize;
public int ECU; 


	public Job(int id, int ecu, int size)
	{ jID= id;
	ECU= ecu;
	jobSize= size; } 


	public String toString()
	{ String str= jID + " " + ECU;
	return str; } }