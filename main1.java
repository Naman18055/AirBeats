//Anuneet Anand

import java.util.*;

class node
{
	int x;
	node n;
	public node()
	{
		x=0;
		n=null;
	}
}

class LL
{
	node head;
	int l;
	public LL()
	{
		head=null;
		l=0;
	}
	public void ins(int y)
	{
		node p=new node();
		p.x=y;
		if (head==null)
			head=p;
		else
		{
			node cur=head;
			while (cur.n!=null)
				cur=cur.n;
			cur.n=p;
		}
		l=l+1;
	}
	public void chkloop()
	{
		int f=0;
		node z=null;
		node sp=head;
		node fp=head;
		while((sp!=null)&&(fp!=null)&&(fp.n!=null))
		{
			sp=sp.n;
			fp=fp.n.n;
			if (sp==fp)
			{	
				f=1;
				z=sp;
				break;
			}
		}
		if (f==0)
		{
			System.out.println("False");
			System.out.println("0");
			prn(head);
		}
		else
		{
			node t=null;
			System.out.println("True");
			int c=1;
			node ptr=z;
			while (ptr.n!=sp)
			{
				ptr=ptr.n;
				c=c+1;
			}
			System.out.println(c);
			node ptra=head;
			int i=0;
			while(i<l-1)
			{
				ptra=ptra.n;
				i=i+1;
			}
			t=ptra.n;
			ptra.n=null;
			node cura=head;
			if (t==head)
				head=head.n;
			else
			{
				while(cura.n!=t)
				{
					cura=cura.n;
				}
				cura.n=cura.n.n;
			}
			prn(head);
			}
	}
	public void makeloop(int x)
	{
		if (x>0)
		{
			int i=1;
			node cur=head;
			node v=null;
			while ((cur!=null)&&(i<x))
			{
				cur=cur.n;
				i=i+1;
			}
			if (cur!=null)
				v=cur;
			node curr=head;
			while(curr.n!=null)
			{
				curr=curr.n;
			}
			curr.n=v;
		}
	}
	public void prn(node y)
	{
		node cur=y;
		while (cur.n!=null)
		{
			System.out.print(cur.x+" ");
			cur=cur.n;
		}
		System.out.println(cur.x);

	}
}

public class main1
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int T=in.nextInt();
		while(T!=0)
		{
			int n=in.nextInt();
			LL Z=new LL();
			for(int i=0;i<n;i++)
			{
				int a=in.nextInt();
				Z.ins(a);
			}
			int x=in.nextInt();
			Z.makeloop(x);
			Z.chkloop();
			T=T-1;
		}
		
	}
}