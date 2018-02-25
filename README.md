# Input-Output Tasks
by Bill Gates
I ran the tasks on a Mackbook pro late 2013 with Macos Sierra, 2.4Ghz and intel i core i5.
##I got these results:
Task											| Time
------------------------------------------------|--------------:
Read file 1-char at a time to String			| 2.051169 sec.
Read file 1-char at a time to StringBuilder		| 0.006324 sec.
Read file line at a time using BufferedReader	| 0.067823 sec.

## Explanation of Results
	The faster one is StringBuilder because There use String to append another String so make fast. The second one is using BufferedReader because is faster than FileReader is faster than inputstream and more secure to read. 