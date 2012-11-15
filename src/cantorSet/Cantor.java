/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cantorSet;

import java.lang.Math;
import java.util.ArrayList;

/**
 *
 * @author Skullum
 */
public class Cantor {
    
    
    private int order;
    private boolean showSteps;
    private ArrayList<String> answer = new ArrayList<String>();
    
    public Cantor(){
        // oh noes no input
    }

   
    
    public Cantor(int order,  boolean showSteps){
        this.order = order;
        this.showSteps = showSteps;
        if(order < 0){
            System.err.println("Bad input");
            System.exit(0);
        }
    }

	void executeCantor(int order, boolean showSteps) {
                
                int numberOfDashes = (int) Math.pow(3, order);
                String[] dashList = new String[numberOfDashes];
                
                // build initial string of dashes
		for(int i=0;i<numberOfDashes;i++){
			dashList[i] = "-";
		} 
                // list is number of dashes -1
                
            //    System.out.println(" DashList length " + dashList.length + " order " + order);
                
		// base case
		if(dashList.length <= 1){
			System.out.println("-");
		}
		// recursive case
		else{
            //            System.out.println("Made it to the else");
			replaceDashes(dashList);
			System.out.println();  
		}
	}


	
	String[] replaceDashes(String[] dashList, int index){
		
		// note that index is both where to start replacing and how many dashes to replace
		// pretty cool amirite? :)
		
		int doubleIndex = index+index;
		String[] newList = new String[dashList.length];
		
		
		// starting at 0 place dashes until index
		for(int i =0; i<index;i++){
			if(dashList[i].equals("-")) // only replace dashes with dashes
				newList[i] = "-";
			else
				newList[i] = " ";
		}
		// starting at index place $ until twice the index
		for(int i=index;i<doubleIndex;i++){
			newList[i] = " ";
		}
		//starting at doubleIndex add dashes until list is finished
		for(int i=doubleIndex;i<dashList.length;i++){
			if(dashList[i].equals("-"))
				newList[i] = "-";
			else
				newList[i] = " ";
		}		
		
		return newList;
	}
	
	void replaceDashes(String[] dashList){

		// base case
		if(dashList.length == 1){
                        answer.add(dashList[0]);
                }
		
		// recursive case
		else{
			int temp = dashList.length/3;
			
			// replace middle dashes with spaces
			dashList = replaceDashes(dashList, temp);
                        
                       // for(int i=0;i<dashList.length;i++){
                  //          System.out.println(dashList[i] + " !!!");
                 //       }
			
			// create three new arrays 
			// put all dashes up to a space into the first one
			// all spaces into the second one
			// and the remaining dashes into the third one.
			String[] segment1 = new String[temp];
			String[] segment2 = new String[temp];
			String[] segment3 = new String[temp];

			for(int i=0;i<temp;i++){
				segment1[i] = dashList[i];
			}
			for(int i=temp;i<temp+temp;i++){
				segment2[i-temp] = dashList[i];
			}
			for(int i=temp+temp;i<dashList.length;i++){
				segment3[i-(temp+temp)] = dashList[i];
			}
			
			// recurse with the three arrays
			replaceDashes(segment1);
			replaceDashes(segment2);
			replaceDashes(segment3);
		}
	}
        
        
        
    /**
     * Getters and Setters
     * @return 
     */
        
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isShowSteps() {
        return showSteps;
    }

    public void setShowSteps(boolean showSteps) {
        this.showSteps = showSteps;
    }
    
    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

}