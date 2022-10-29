package PE1;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Kakshil Patel
Student Number: 216393910
Course Section: Section B
*/


public class PE1 {
	Maze dogMaze; 
	/**
	 * This method sets up the maze using the given input argument
	 * @param maze is a maze that is used to construct the dogMaze
	 */
	public void setup(String[][] maze) {
		/* insert your code here to create the dogMaze 
		 * using the input argument. 
		 */
		this.dogMaze = new Maze(maze);
	}

	/**
	 * This method returns true if the number of 
	 * gates in dogMaze >= 2. 
	 * @return it returns true, if enough gate exists (at least 2), otherwise false.
	 */
	public boolean enoughGate(){
		// insert your code here. Change the return value to fit your purpose. 
	    int count = 0;
	    count += recTop(this.dogMaze.getMaze(), this.dogMaze.getMaze()[0].length) + recLeft(this.dogMaze.getMaze(), this.dogMaze.getMaze().length) + recBottom(this.dogMaze.getMaze(), this.dogMaze.getMaze()[this.dogMaze.getMaze().length-1].length) + recRight(this.dogMaze.getMaze(), this.dogMaze.getMaze().length);

	    if (count >= 2){
	    	return true;
	    }else{
	    	return false;
	    }	
	}
	
	/**
	 * This method is a helper method that uses indirect recursion returns number of open gates in the top border.
	 * @param k is the maze used to recurse the border for open gates.
	 * @param n is number of open gates.
	 * @return it returns the number of open gates, if no open gates, it return 0.
	 */
	//Recursion through top border
	public static int recTop(String [][] k, int n){
		if(n <= 0){
	    	return 0;
	    }
	    if(k[0][n-1].charAt(0) == '0'){
	    	return (recTop(k, n-1) + 1);
	    }else{
	      return (recTop(k, n-1));
	    }
	}
	
	/**
	 * This method is a helper method that uses indirect recursion returns number of open gates in the left border.
	 * @param k is the maze used to recurse the border for open gates.
	 * @param n is number of open gates.
	 * @return it returns the number of open gates, if no open gates, it return 0.
	 */
	  //Recursion through left border
	public static int recLeft(String [][] k, int n){
	    if(n <= 0){
	      return 0;
	    }
	    if(k[n-1][0].charAt(1) == '0'){
	      return (recLeft(k, n-1) + 1);
	    }else{
	      return (recLeft(k, n-1));
	    }
	}

	/**
	 * This method is a helper method that uses indirect recursion returns number of open gates in the bottom border.
	 * @param k is the maze used to recurse the border for open gates.
	 * @param n is number of open gates.
	 * @return it returns the number of open gates, if no open gates, it return 0.
	 */
    //Recursion through bottom border
    public static int recBottom(String [][] k, int n){
    	if(n <= 0){
	      return 0;
	    }
	    if(k[k.length-1][n-1].charAt(2) == '0'){
	      return (recBottom(k, n-1) + 1);
	    }else{
	      return (recBottom(k, n-1));
	    }
    }

    /**
	 * This method is a helper method that uses indirect recursion returns number of open gates in the right border.
	 * @param k is the maze used to recurse the border for open gates.
	 * @param n is number of open gates.
	 * @return it returns the number of open gates, if no open gates, it return 0.
	 */
    //Recursion through right border
    public static int recRight(String [][] k, int n){
	    if(n <= 0){
	      return 0;
	    }
	    if(k[n-1][k[0].length-1].charAt(3) == '0'){
	      return (recRight(k, n-1) + 1);
	    }else{
	      return (recRight(k, n-1));
	    }
    }
	  
	  
	  
	/**
	 * This method finds a path from the entrance gate to 
	 * the exit gate. 
	 * @param row is the index of the row, where the entrance is.
	 * @param column is the index of the column, where the entrance is.
	 * @return it returns a string that contains the path from the start to the end. 
	 * The return value should have a pattern like this (i,j)(k,l),...
	 * The first pair of the output must show the entrance given as the 
	 * input parameter (i.e. (row,column)
	 * No whitespace is allowed in the output.  
	 */
    public String findPath (int row, int column) {
		// insert your code here. Change the return value to fit your purpose. 
    	String s = findPathHelper(this.dogMaze.getMaze(), row, column, row, column);
        return s;
    }
	
	


    /**
     * This method is the helper method that uses indirect recursion to find a path from entry to exit.
     * If the entry and exit is on the same row and index, the string should print out only the index of the entry.
     * The algorithm allows for more than 2 gate exits assuming there are at least 2 gates.
     * 
     * @param w represents the 2D maze
	 * @param row is the index of the row, where the entrance is but this value changes through recursion to find next index.
	 * @param column is the index of the column, where the entrance is but this value changes through recursion to find next index.
	 * @param r is the index of the row, where the entrance is but this value does not change and remains a constant value for entry row.
	 * @param c is the index of the column, where the entrance is but this value does not change and remains a constant value for entry column.
	 * @return it returns a string that contains the path from the start to the end. 
	 * The return value is a the matrix of the maze but its values have been changed through the algorithm search, and the correct values,
	 * are marked, and the wrong path dead ends are crossed out.
	 */ 
	public static String findPathHelper(String [][] w, int row, int col, int r, int c){ 
	  	//insert your code here. Change the return value to fit your purpose.
	 

	    //if 2 gates at same corner, entry & exit 
		if(((r==c) && w[r][c].charAt(0) == '0' && w[r][c].charAt(1) == '0')|| 
	      ((r== 0 && c == w[0].length-1) && (w[r][c].charAt(3) == '0' && w[r][c].charAt(0) == '0')) || 
	      ((r == w.length-1 && c == w[0].length-1) && (w[r][c].charAt(2) == '0' && w[r][c].charAt(3) == '0'))|| 
	      ((r== w.length-1 && c == 0) && (w[r][c].charAt(1) == '0' && w[r][c].charAt(2) == '0'))){
			w[r][c] += '-';
	        System.out.print("("+ r + "," + c + ")");
	        return "";
	    
	    }
	      
	    //right gate exit
	    if(c == 0){
	      if(((col == w[0].length - 1 && w[row][col].charAt(3) == '0' )|| 
	        (row == w.length - 1 && w[row][col].charAt(2) == '0' )|| 
	        (row == 0 && w[row][col].charAt(0) == '0' )||
	        (col == 0 && w[row][col].charAt(1) == '0' )) && (row != r)){
	        w[row][col] += '-';
	        return "";
	      }
	    }
	    //top gate exit
	    if(r == 0){ 
	      if(((col == w[0].length - 1 && w[row][col].charAt(3) == '0' )|| 
	        (row == w.length - 1 && w[row][col].charAt(2) == '0' )|| 
	        (row == 0 && w[row][col].charAt(0) == '0' )||
	        (col == 0 && w[row][col].charAt(1) == '0' )) && (col!= c)){
	        w[row][col] += '-';
	        return "";
	      }
	    }
	    //left gate exit
	    if(c == w[0].length-1){
	      if(((col == w[0].length - 1 && w[row][col].charAt(3) == '0' )|| 
	        (row == w.length - 1 && w[row][col].charAt(2) == '0' )|| 
	        (row == 0 && w[row][col].charAt(0) == '0' )||
	        (col == 0 && w[row][col].charAt(1) == '0' )) && (row!= r)){
	        w[row][col] += '-';
	        return "";
	      }
	    }
	    //bottom gate exit
	    if(r == w.length -1){
	      if(((col == w[0].length - 1 && w[row][col].charAt(3) == '0' )|| 
	        (row == w.length - 1 && w[row][col].charAt(2) == '0' )|| 
	        (row == 0 && w[row][col].charAt(0) == '0' )||
	        (col == 0 && w[row][col].charAt(1) == '0' )) && (col!= c)){
	        w[row][col] += '-';
	        return "";
	      }
	    }
	  
	      
	    //top left corner index movement
	    if(col == 0 && row == 0){
	        //down
	    	if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row+1, col, r, c);
	        //right
	    	}else if(w[row][col+1].charAt(1) == '0' && w[row][col+1].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col+1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
	    		//down
	    		if(w[row+1][col].length() >= 5  && w[row+1][col].charAt(0) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row+1, col, r, c);
	    		//right
	    		}else if(w[row][col+1].length() >= 5 && w[row][col+1].charAt(1) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row, col+1, r, c);
	        	}
	    	}
	    //bottom left corner index movement
	    }else if(col == 0 && row == w.length-1){
	    	//up
	    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row-1, col, r, c);
	    	//right
	    	}else if(w[row][col+1].charAt(1) == '0' && w[row][col+1].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col+1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
		        //up
		        if(w[row-1][col].length() >= 5 && w[row-1][col].charAt(2) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row-1, col, r, c);
		        //right
		        }else if(w[row][col+1].length() >= 5 && w[row][col+1].charAt(1) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row, col+1, r, c);
		        }
	    	}
	    //top right corner index movement
	    }else if(col == w[0].length-1 && row == 0){
	    	//down
	    	if(w[row+1][col].charAt(0) == '0' && w[row][col-1].length() < 5){            
	    		w[row][col] += '-';
	    		findPathHelper(w, row+1, col, r, c);
	    	//left
	    	}else if(w[row][col-1].charAt(3) == '0' && w[row+1][col].length() < 5){      
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col-1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
		        //left
		        if(w[row][col-1].length() >= 5 && w[row][col-1].charAt(3) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row, col-1, r, c);
		        //down
		        }else if(w[row+1][col].length() >= 5 && w[row+1][col].charAt(0) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row+1, col, r, c);
		        }
	    	}
		//bottom right corner index movement
	    }else if(col == w[0].length-1 && row == w.length-1){
		    	//up
	    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() < 5){
	    		w[row][col] += '-';
		    	findPathHelper(w, row-1, col, r, c);
		    	//left
		    }else if(w[row][col-1].charAt(3) == '0' && w[row][col-1].length() < 5){
		    	w[row][col] += '-';
		    	findPathHelper(w, row, col-1, r, c);
		    }else{
	    		//if deadend, go back and mark as x
		    	//up
		    	if(w[row-1][col].length() >= 5 && w[row-1][col].charAt(2) == '0'){
		    		w[row][col] = "xxxxx";
		    		findPathHelper(w, row-1, col, r, c);
		    		//left
		    	}else if(w[row][col-1].length() >= 5 && w[row][col-1].charAt(3) == '0'){
		    		w[row][col] = "xxxxx";
		    		findPathHelper(w, row, col-1, r, c);
		    	}
		    }
		//left border index movement
	    }else if(col == 0 && (row != 0 && row != w.length-1)){
	    	//up
	    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row-1, col, r, c);
	    		//down
	    	}else if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row+1, col, r, c);
	    		//right
	    	}else if(w[row][col+1].charAt(1) == '0' &&  w[row][col+1].length() < 5){ 
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col+1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
	    		//up
	    		if(w[row-1][col].length() >= 5 && w[row-1][col].charAt(2) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row-1, col, r, c);
	    			//down
	    		}else if(w[row+1][col].length() >= 5 && w[row+1][col].charAt(0) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row+1, col, r, c);
	    			//right
	    		}else if(w[row][col+1].length() >= 5 && w[row][col+1].charAt(1) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row, col+1, r, c);
	    		}
	    	}
	    //top border index movement
	    }else if(row == 0 && (col != 0 && col != w[0].length-1)){
	    	//left
	    	if(w[row][col-1].charAt(3) == '0'&& w[row][col-1].length() < 5){     
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col-1, r, c);
	    		//down
	    	}else if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row+1, col, r, c);
	    		//right
	    	}else if(w[row][col+1].charAt(1) == '0' && w[row][col+1].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col+1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
	    		//left
	    		if(w[row][col-1].length() >= 5 && w[row][col-1].charAt(3) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row, col-1, r, c);
	    			//down
	    		}else if(w[row+1][col].length() >= 5 && w[row+1][col].charAt(0) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row+1, col, r, c);
	    			//right
	    		}else if(w[row][col+1].length() >= 5 && w[row][col+1].charAt(1) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row, col+1, r, c);
	    		}
	    	}   	
	    //bottom border index movement
	    }else if(row == w.length-1 && (col != 0 && col != w[0].length-1)){
	    	//left
	    	if(w[row][col-1].charAt(3) == '0' &&  (w[row][col-1].length() < 5)){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col-1, r, c);
	    		//up
	    	}else if(w[row-1][col].charAt(2) == '0'  && w[row-1][col].length() < 5){
	    		w[row][col] += '-';
	        	findPathHelper(w, row-1, col, r, c);
	        	//right
	    	}else if(w[row][col+1].charAt(1) == '0' &&  w[row][col+1].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col+1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
	    		//up
	    		if(w[row-1][col].length() >= 5 && w[row-1][col].charAt(2) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row-1, col, r, c);
		        //left
		        }else if(w[row][col-1].length() >= 5 && w[row][col-1].charAt(3) == '0'){
		        	w[row][col] = "xxxxx";
		        	findPathHelper(w, row, col-1, r, c);
		        //right
		        }else if(w[row][col+1].length() >= 5 && w[row][col+1].charAt(1) == '0'){
		        	w[row][col] = "xxxxx";
		        	findPathHelper(w, row, col+1, r, c);
		        }
	    	}
	    //right border index movement
	    }else if(col == w[0].length-1 && (row != 0 && row != w.length-1)){
	    	//up
	    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row-1, col, r, c);
	    		//down
	    	}else if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row+1, col, r, c);
	    		//left
	    	}else if(w[row][col-1].charAt(3) == '0' && w[row][col-1].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col-1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
	    		//up
	    		if(w[row-1][col].length() >= 5 && w[row-1][col].charAt(2) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row-1, col, r, c);
	    			//left
	    		}else if(w[row][col-1].length() >= 5 && w[row][col-1].charAt(3) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row, col-1, r, c);
	    			//down
	    		}else if(w[row+1][col].length() >= 5 && w[row+1][col].charAt(0) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row+1, col, r, c);
	    		}
	    	}
	    //inside index movement
	    }else if ((row >= 1 && row < w.length -1) && (col >= 1 && col < w[0].length - 1)){
	    	//up
	    	if(w[row-1][col].charAt(2) == '0' &&  w[row-1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row-1, col, r, c);
	    		//left
	    	}else if(w[row][col-1].charAt(3) == '0' &&  w[row][col-1].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col-1, r, c);
	    		//down
	    	}else if(w[row+1][col].charAt(0) == '0' &&  w[row+1][col].length() < 5){
	    		w[row][col] += '-';
	    		findPathHelper(w, row+1, col, r, c);
	    		//right
	    	}else if(w[row][col+1].charAt(1) == '0' &&  w[row][col+ 1].length() < 5){           
	    		w[row][col] += '-';
	    		findPathHelper(w, row, col+1, r, c);
	    	}else{
	    		//if deadend, go back and mark as x
	    		//up
	    		if(w[row-1][col].length() >= 5 && w[row-1][col].charAt(2) == '0'){
	    			w[row][col] = "xxxxx";
	    			findPathHelper(w, row-1, col, r, c);
			    //left
		        }else if(w[row][col-1].length() >= 5 && w[row][col-1].charAt(3) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row, col-1, r, c);
		        //down
		        }else if(w[row+1][col].length() >= 5 && w[row+1][col].charAt(0) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row+1, col, r, c);
		        //right
		        }else if(w[row][col+1].length() >= 5 && w[row][col+1].charAt(1) == '0'){
		          w[row][col] = "xxxxx";
		          findPathHelper(w, row, col+1, r, c);
		        }
	    	}  
	    } 
	    print(w, r, c);
	    return "";
	}
	  
	/**
     * This method is the helper method that uses indirect recursion to print the path from entry to exit.
     * It is called in the helper method of findPathHelper. When the the findPathHelper() algorithm searches and finds a valid path,
     * from entry to exit, it marks down the valid path. The print() method, searches and uses this marked path, to print the path,
     * from entry to exit.
	 * @param row is the index of the row where the entrance is, and  it is called using parameter r from findPathHelper.
	 * @param column is the index of the column where the entrance and  it is called using parameter c from findPathHelper.
	 * @return it returns a string that contains the path from the start to the end. 
	 * The return value is a string in the form of (i,j)(k,l),...
	 */ 
	public static String print(String [][] w, int row, int col){
		
		if(w[row][col].length() >= 5 && w[row][col].charAt(0) != 'x'){
			System.out.print("("+ row + "," + col + ")");
	    	}
	    	//if valid path in left border
	    	if(col == 0 && (row != 0 && row != w.length-1)){
	    		//up
	    		if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() >= 5){
	    			w[row][col] = "xxxxx";
	    			print(w, row-1, col);
	    			//down
	    		}else if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() >= 5){
	    			w[row][col] = "xxxxx";
	    			print(w, row+1, col);
	    			//right
	    		}else if(w[row][col+1].charAt(1) == '0' &&  w[row][col+1].length() >= 5){ 
	    			w[row][col] = "xxxxx";
	        	print(w, row, col+1);
	    		}
	    	}
	    
		    //if valid path in inside the borders
		    	
		    if ((row >= 1 && row < w.length -1) && (col >= 1 && col < w[0].length - 1)){
		    		//up
		    	if(w[row-1][col].charAt(2) == '0' &&  w[row-1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row-1, col);
		    		//left
		    	}else if(w[row][col-1].charAt(3) == '0' &&  w[row][col-1].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row, col-1);
		    		//down
		    	}else if(w[row+1][col].charAt(0) == '0' &&  w[row+1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row+1, col);
		    	}else if(w[row][col+1].charAt(1) == '0' &&  w[row][col+ 1].length() >= 5){           
		    		w[row][col] = "xxxxx";
		    		print(w, row, col+1);
		        
		    	}
		    }
		    //if valid path in bottom border
		    if(row == w.length-1 && (col != 0 && col != w[0].length-1)){
		      //left
		    	if(w[row][col-1].charAt(3) == '0' &&  (w[row][col-1].length() >= 5)){
	
		    		w[row][col] = "xxxxx";
		    		print(w, row, col-1);
		    		//up
		    	}else if(w[row-1][col].charAt(2) == '0'  && w[row-1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row-1, col);
		    		//right
		    	}else if(w[row][col+1].charAt(1) == '0' &&  w[row][col+1].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row, col+1);
		    	}
		    }
		    //if valid path in right border
		    if(col == w[0].length-1 && (row != 0 && row != w.length-1)){
	
		        //up
		    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row-1, col);
		    		//down
		    	}else if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() >=5){
		    		w[row][col] = "xxxxx";
		        	print(w, row+1, col);
		        	//left
		    	}else if(w[row][col-1].charAt(3) == '0' && w[row][col-1].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row, col-1);
		    	}
		    }
		    	//if valid path in bottom right corner
		    if(col == w[0].length-1 && row == w.length-1){
		    	//up
		    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row-1, col);
		    		//left
		    	}else if(w[row][col-1].charAt(3) == '0' && w[row][col-1].length() >= 5){
		    		w[row][col] = "xxxxx";
		    	  	print(w, row, col-1);
		    	}
		    }
		    //if valid path in top left corner
		    if(col == 0 && row == 0){
		    	//down
		    	if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() >= 5){
		    	  w[row][col] = "xxxxx";
		    	  print(w, row+1, col);
		    	 //right
		    	}else if(w[row][col+1].charAt(1) == '0' && w[row][col+1].length() >= 5){
		    	  w[row][col] = "xxxxx";
		    	  print(w, row, col+1);
		    	}
		    }
		    //if valid path in bottom left corner
		    if(col == 0 && row == w.length-1){
		    	//up
		    	if(w[row-1][col].charAt(2) == '0' && w[row-1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row-1, col);
		    		//right
		    	}else if(w[row][col+1].charAt(1) == '0' && w[row][col+1].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row, col+1);
		    	}
		    }
		      //if valid path in top right corner
		    if(col == w[0].length-1 && row == 0){
		    	//down
		    	if(w[row+1][col].charAt(0) == '0' && w[row][col-1].length() >= 5){            
		    		w[row][col] = "xxxxx";
		    		print(w, row+1, col);
		    		//left
		    	}else if(w[row][col-1].charAt(3) == '0' && w[row+1][col].length() >= 5){      
		    		w[row][col] = "xxxxx";
		    		print(w, row, col-1);
		    	}
		    }
		    //if valid path in top border
		    if(row == 0 && (col != 0 && col != w[0].length-1)){
		       //left
		    	if(w[row][col-1].charAt(3) == '0'&& w[row][col-1].length() >= 5){     
		    		w[row][col] = "xxxxx";
		    		print(w, row, col-1);
		    		//down
		    	}else if(w[row+1][col].charAt(0) == '0' && w[row+1][col].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row+1, col);
		    		//right
		    	}else if(w[row][col+1].charAt(1) == '0' && w[row][col+1].length() >= 5){
		    		w[row][col] = "xxxxx";
		    		print(w, row, col+1);
		    	}
		    }
		    return "";
		}
	
	}


/**
 * This class defines a <code> maze </code> using a 2D array. 
 * To complete the code, you should not change the method 
 * signatures (header). 
 *
 */

class Maze{
	private String [][] maze; 
	
	/**
	 * This constructor makes the maze. 
	 * @param maze is a 2D array that contains information 
	 * on how each cell of the array looks like. 
	 */
	public Maze(String[][] maze) {
		/*complete the constructor so that the maze is 
		 * a deep copy of the input parameter. 
		 */
		int x = 0;
	    while (x < maze.length){
	    	int y = 0;
	    	while (y < maze[x].length){
	    		this.maze[x][y] = maze[x][y];
	    		y++;
	    	}
	    	x++;
	    }
	}

	/**
	 * This accessor (getter) method returns a 2D array that
	 * represents the maze
	 * @return it returns a reference to the maze
	 */
	public String[][] getMaze(){
		/* complete this method providing that a clone of 
		 * the maze should be returned. 
		 * you may want to change the return value to fit your purpose.
		 */
		return this.maze; 
	}
	
	/**
	 * This prints out the string in a specific pattern [...]
	 * @return it returns the printed String of the maze
	 */
	@Override 
	public String toString() {
		//insert your code here. Change the return value to fit your purpose. 
		String printed = "";
	    for (int i = 0; i < this.maze.length; i++){
	    	printed += "[";
	    	for (int j = 0; j < this.maze[i].length; j++){
	    		printed += " " + this.maze[i][j] + " ";
	    	}
	    	printed += "]\n";
	    }
	    return printed;
	}
	
}// end of class Maze
