


public class PCB 
{ int pid, cut, ecu, jobSize;
State state;
	

	public PCB(int pid, int ecu, int size) 
	{ this.pid = pid;
	this.ecu = ecu;
	jobSize= size;
	state = State.New;
	cut = 0; }
	

	public void admit() 
	{ state = State.Ready; }
	

	public void waiting() 
	{ state = State.Waiting; }
	

	public void run() 
	{ state = State.Running; }
	

	public void terminate() 
	{ state = State.Terminated; } }
