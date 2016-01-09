// cal_client.java    
    
import calc_val.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
public class cal_client
{
    static calc calcimpl;
    public static void main(String args[])
    {
      try
      {
        double result=0.0,num1=0.0,num2=0.0;

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objref=orb.resolve_initial_references("NameService");

        NamingContextExt ncref=NamingContextExtHelper.narrow(objref);

        String pathname="calc";
        calcimpl=calcHelper.narrow(ncref.resolve_str(pathname));


       int ch=1;

       while(ch!=0)
       {
        System.out.println("1. (+)Addition");
        System.out.println("2. (-)Subtraction");
        System.out.println("3. (*)Multiplication");
        System.out.println("4. (/)Division");
	System.out.println("5. (%)Modular");
        System.out.println("6. Square Root");
        System.out.println("7. Power");
        System.out.println("0. Exit");

        BufferedReader in1=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter your choice:");
        ch=Integer.parseInt(in1.readLine());
        //edit by vindya
	if(ch<=7&&ch>=0)
	{
        if(ch==0)
          break;

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	//edit for single input
	if(ch==6){
		System.out.println("enter number1:");
        	num1=Double.parseDouble(in.readLine());
	}
	else{
        	System.out.println("enter number1:");
        	num1=Double.parseDouble(in.readLine());

        	System.out.println("enter number2:");
        	num2=Double.parseDouble(in.readLine());
	
	
	}

        switch(ch)
        {
          case 1:
              result=calcimpl.addfn(num1,num2);
              break;

          case 2:
              result=calcimpl.subfn(num1,num2);
              break;

          case 3:
              result=calcimpl.mulfn(num1,num2);
              break;

          case 4:
              result=calcimpl.divfn(num1,num2);
              break;

	  case 5:
              result=calcimpl.modfn(num1,num2);
              break;

	case 6:
              result=calcimpl.sqrtfn(num1);
              break;

	case 7:
              result=calcimpl.powerfn(num1,num2);
              break;

        }
              System.out.println("result is:"+result);
	}else 
		System.out.println("Invalid Choice");
        }

      }
      catch(Exception e)
      {
         System.out.println(e);
      }
    }

}