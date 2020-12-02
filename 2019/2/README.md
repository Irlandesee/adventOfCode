#PREMISE:

#NOTES:
	-> intcode program: list of intergers separated by commas
		-to run one, start by looking at the first integer
		- called position 0 -> opcode.
	-> opcode: it indicates what to do.
			either 1,2, or 99.
		example: 99 means that the program is finished and shuoul
				immediately halt.
		- encountering an unknown opcode means something went wrong

		- opcode 1: adds toghether numbers read from two positions and 
					stores the result in a third position.

		- the 3 integers immediately after the opcode tell you these 
			3 positions:
				- the first 2 indicate the positions from which you 
					should read the input values, and indicates the 
					position at which the output should be stored.
		- example: 
			->(1,10,20,30):
			- it should read the values at positions 10 and 20, add 
				those values , then overwrite the value at position 
				30 with their sum.
		- opcode 2: works exactly opcode 1, excepti it multiplies 
				the two inputs instead of adding them. 

		-once done processing an opcode, move to the next one by stepping
			forward 4 positions
		example:
			1,9,10,3,2,3,11,0,99,30,40,50
			-same program split into multiple lines
				
				1,9,10,3
				2,3,11,0
				99,
				30,40,50
			-the first four integers, 1,9,19,3 are at positions 0,1,2 and 3
				-> the first opcode (1,addition)
				-> the positions of the 2 inputs (9, 10)
				-> the position of the output (3)
				- handling this opcode:
					-> first get the values at the input positions:
						-> pos[9] contains 30
						-> pos[10] contains 40
						-> 30+40 = 70
						-> store this value at the output position
						-> pos[3] = 70
				->the program looks like this
					1,9,10,70
					2,3,11,0,
					99,
					30,40,50

				-Step forward 4 positions to reach the next opcode 2.
				-step forward 4 more positions to reach opcode 99,
					halting the program

#TESTCASES
	-1,0,0,0,99 becomes 2,0,0,0,99 (1+1 = 2)
	-2,3,0,3,99 becomes 2,3,0,6,99 (3*2 = 6)
	-2,4,4,5,99,0 becomes 2,4,4,5,99,9801 (99 * 99 = 9801)
	-1,1,1,4,99,5,6,0,99 becomes 30,1,1,4,2,5,6,0,99




#PROBLEMS: