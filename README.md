# Multiprogramming-Batch-Operating-System
A simulation of a simple multiprogramming batch operating system. The system hardware specifications assumed in the simulation are as follows:
- A single- core CPU.
- A RAM with 192 MB available for user programs.

The simulation covers process scheduling, and the operating system maintains a single ready queue. Moreover, the CPU Scheduler follows the First-Come, First-Served (FCFS) scheduling algorithm policy.

## Input
In the beginning of the simulation, the program generates a file "Jobs.txt" containing a number of jobs (at least 100) each along with the following specifications:
- Job ID (JID): a unique identification number for the job.
- Expected CPU usage (ECU): the expected execution time (in units). This should be no greater than the actual CPU usage (CUT). The ECU is generated randomly with a uniform distributed between 16 and 512 units.
- Expected memory requirement (EMR): the memory (in KB) needed by the program. The EMR is generated randomly with a uniform distributed between 16 KB and 256 KB.

## Output
The program writes the statistics as follows in the output file "Results.txt":
- Total number of jobs processed.
- Average/Minimum/Maximum job size in KB.
- Number of jobs that completed normally.
- Number of jobs that completed abnormally.
