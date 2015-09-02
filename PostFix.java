// Assignment 1    Due:   9/2/2015

//Justin Cody                                        
//N03112028  

//CPS315-01





import java.util.*;
import java.io.*;

public class PostFix
{
   public static void main(String [] args) throws Exception
   {
       String temp = "";
       String fileName = "in.dat";
       int ifError = 0;
       double NumTemp;
       double x,y,z;
       int lineCount = 1;
      
       Scanner fileScan = new Scanner(new File(fileName));
       
       Stack <Double> stacks = new Stack<Double>();
     
    System.out.println("Justin Cody's Postfix Calculator");
    System.out.println("________________________________");  
    System.out.println(" ");
     while(fileScan.hasNextLine())
     {
                 String line = fileScan.nextLine();
               
                 Scanner scan = new Scanner(line);
                 
            while(scan.hasNext())
            {
                temp = scan.next();
              
                
                try
                {
                    NumTemp = Double.parseDouble(temp); 
                    stacks.push(NumTemp);
                }
                catch(NumberFormatException e)
                {
                  //System.out.println("it reached expection box");  //test
                  //System.out.println("temp"+ temp);                //check value
                }
          
                     if(temp.equals("+"))
                     {
                    
                        x = stacks.pop();
                        y = stacks.pop();
                     
                        z = x+y;
                        stacks.push(z);
                       
                       
                    }
                    else if(temp.equals("/"))
                         {
                             x = stacks.pop();
                             y = stacks.pop();
                             z = y/x;
                             if(x <=0)
                             {
                                 System.out.print(lineCount+". "+"Error! Division by zero. "); 
                                 ifError = 1;
                             }
                            
                             stacks.push(z);
                             
                         }
                         else if(temp.equals("*"))
                         {
                             x = stacks.pop();
                             y = stacks.pop();
                             z = y*x;
                             stacks.push(z);
                           
                             
                         }
                         else if(temp.equals("-"))
                         {
                             x = stacks.pop();
                             y = stacks.pop();
                             z = y-x;
                             stacks.push(z);
                           
                         }
                         else if(temp.equals("_"))
                         {
                             
                             x = stacks.pop();
                             z = -x;
                          
                             stacks.push(z);
                            
                         }
                         else if(temp.equals("#"))
                         {
                            
                             x = stacks.pop();
                             if(x <= 0)
                             {
                                System.out.print(lineCount+". "+"Error! sqrt of negative value. "); 
                               ifError = 1;
                            }
                            
                              z = Math.sqrt(x);
                              stacks.push(z);
                               
                         }
                         else if(temp.equals("^"))
                         {
                             x = stacks.pop();
                            
                             y = stacks.pop();
                             
                             z =  Math.pow(y,x);
                            
                             stacks.push(z);
                          
                           
                         }
                                    
          }
        
      
           try
           {
               z = stacks.pop();
           }
           catch(EmptyStackException a)
           {
             z = 0.0;
           }
            
           if(ifError == 0)                      //used to determine which output format to use
           {
               System.out.println( lineCount+". "+"The Value of "+'"'+ line +'"'+  " is " + z);
               System.out.println(" ");
           }
           else if(ifError == 1)
           {
               System.out.println("In expression " +'"'+ line +'"');
               System.out.println(" ");
                ifError = 0;
             
           }
         
           ++lineCount;
       }
      System.out.println("End of expressions within " + '"'+ fileName + '"' + " file.");
}
}

