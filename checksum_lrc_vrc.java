
import java.util.*;


//checksum***************************
class checksum extends Thread{
public void finaladd(ArrayList<Integer>help2,ArrayList<ArrayList<Integer>>arr) {
	int n=arr.size();
	ArrayList<Integer>help=new ArrayList<>();
	
	int carry=0;
	for(int i=n-1;i>=0;i--)
	{
		int s=0;
		for(int j=n-1;j>=0;j--)
		{
			s+=arr.get(i).get(j);
		}
		s+=carry;
		if(s%2==1)
		{
			help.add(1);
			carry=1;
		}
		else if(s%2==0 && s>1)
		{
			help.add(0);
			carry=1;
		}
		else {
			help.add(0);
			carry=0;
		}
	}
	ArrayList<Integer>finalans=new ArrayList<>();
	int carr=0;
	for(int i=help.size()-1;i>=0;i--)
	{
		int s=0;
		s+=help.get(i)+help2.get(i);
		if(s%2==0)
		{
			finalans.add(0);
			carr=1;
		}
		else if(s%2!=0)
		{
			finalans.add(1);
			carr=1;
		}
		else {
			finalans.add(0);
			carr=0;
		}
	}
	
	for(int i=finalans.size()-1;i>=0;i--)
	{
		System.out.print(finalans.get(i)+" ");
	}
	System.out.println();
	
	for(int i=0;i<finalans.size();i++)
	{
		if(finalans.get(i)!=1)
		{
			System.out.println("Error");
			return;
		}
	}
	System.out.println("Clear");
}
	
	public void addarr(ArrayList<Integer>finalhelp,ArrayList<ArrayList<Integer>>arr)
	{
		int n=arr.size();
		ArrayList<Integer>help=new ArrayList<>();
		int carry=0;
		for(int i=n-1;i>=0;i--)
		{
			int s=0;
			for(int j=n-1;j>=0;j--)
			{
				s+=arr.get(i).get(j);
			}
			s+=carry;
			if(s%2==1)
			{
				help.add(1);
				carry=1;
			}
			else if(s%2==0 && s>1)
			{
				help.add(0);
				carry=1;
			}
			else {
				help.add(0);
				carry=0;
			}
		}
		for(int i=0;i<help.size();i++)
		{
			if(help.get(i)==0)
				finalhelp.add(1);
			else
				finalhelp.add(0);
		}
		
	}
	public void run()
	{
		synchronized(this) {
		Scanner p=new Scanner(System.in);
		int n=p.nextInt();
		ArrayList<ArrayList<Integer>>arr=new ArrayList();
		ArrayList<Integer>inp=new ArrayList();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++) {
			int c;c=p.nextInt();
			inp.add(c);}
			arr.add(inp);
		}
		ArrayList<Integer>finalhelp=new ArrayList<>();
		
		addarr(finalhelp,arr);
		
		finaladd(finalhelp,arr);
		this.notify();
		}
	}
}


//LRC***********************************
class LRC extends Thread{
	public boolean checkforerr(ArrayList<Integer>tocheck,ArrayList<Integer>check)
	{
		for(int i=0;i<tocheck.size();i++)
		{
			int f=tocheck.get(i);
			int s=check.get(i);
			if(f!=s)
				return false;
		}
		return true;
	}
	public void run()
	{
		Scanner p=new Scanner(System.in);
		int n=p.nextInt();
		ArrayList<ArrayList<Integer>>arr=new ArrayList();
		ArrayList<Integer>inp=new ArrayList();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++) {
			int c;c=p.nextInt();
			inp.add(c);}
			arr.add(inp);
		}
		ArrayList<Integer>checkres=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			checkres.add(arr.get(0).get(i));
		}
		
		ArrayList<Integer> res=new ArrayList();
		
		for(int i=0;i<n;i++) {
			int d=0;
			for(int j=0;j<n;j++)
			{
				if(arr.get(i).get(j)==1)
				{
					d++;
				}	
			}
			if(d%2==1)
			{
				res.add(1);
			}
			else {
				res.add(0);
			}
		}
		if(checkforerr(checkres,res))
		{
			System.out.println("No error");
		}
		else {
			System.out.println("Error found");
		}
	}
	
}


//VRC**********************************************************
class VRC extends Thread{
	public boolean check(ArrayList<Integer>arr,int target)
	{
		int d=0;
		for(int i=0;i<arr.size();i++) {
		if(arr.get(i)==1)
			d++;
		}
		if(d%2==0)
			return true;
		else return false;
	}
	public void run()
	{
		Scanner p=new Scanner(System.in);
		int n=p.nextInt();
		ArrayList<Integer>arr=new ArrayList<>();
		
			//Scanner p=new Scanner(System.in);
			for(int i=0;i<n;i++)
			{
				int c;
				c=p.nextInt();
				arr.add(c);
			}
			int d=0;
			for(int i=0;i<n;i++)
			{
				int f=arr.get(i);
				if(f==1)
				d++;
			}
			if(d%2==1)
			{
				arr.add(1);
			}
			System.out.println("Enter the data to be sent");
			System.out.println("Give Input");
			int in;
			in=p.nextInt();
			ArrayList<Integer>sendata=new ArrayList<>();
			for(int i=0;i<in;i++)
			{
				int g;
				g=p.nextInt();
				sendata.add(g);
			}
		if(check(sendata,d))
			System.out.println("No error");
		else
			System.out.println("Error found");
	}
}
public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		
//			VRC vrc=new VRC();
//			vrc.start();
//			LRC lrc=new LRC();
//			lrc.start();
		checksum chksm=new checksum();
		chksm.start();
		synchronized(chksm) {
			chksm.wait();
		}
		
	}

}

