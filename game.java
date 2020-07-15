package game.java_files;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class MyThread implements Runnable {
    String name;
    Thread t;
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();


    MyThread (String thread){
        name = thread;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
        for (int i=0;i<=50;i++)
            m.put(Integer.valueOf(i), Integer.valueOf(1));
    }
    public void run() {

//        Thread.sleep(1000);
        try {
            for(int i = 10; i > 0; i--) {
                {
                    int t= (int)(Math.random()*50);
                    System.out.println(name + ": " + t);
                    Integer u=Integer.valueOf(t);
                   if( (Integer) m.get(u) ==null)
                       m.put(u, Integer.valueOf(1));
                   else
                   {
                       Integer y=(Integer) m.get(u);


                       int r=y.intValue();


                       Integer q=Integer.valueOf(r+1);

                       m.put(u, q);
                   }


                }

                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
////        System.out.println(name + " exiting.");
    }
}
class MultiThread {
    public static void main(String args[]) {
        System.out.println("enter no of players");

        Scanner in = new Scanner(System.in);
        int n=3;
//        System.out.println();
        String[] name = new String[3];
        Integer[] cou = new Integer[3];
        MyThread[] obj= new MyThread[3];

        for(int i=1;i<=n;i++)
        {
            name[0]="sam";
            name[1]="eon";
            name[2]="steve";
            break;
        }

        for(int i=1;i<=n;i++)
        {
            obj[i-1]=new MyThread(name[i-1]);
            cou[i-1]=0;
        }

        try {
//            System.out.println(one.t);

            Thread.sleep(1000);
            int e=0;

            for(int i=10;i>0;i--)
            {
                int no=(int)(Math.random()*50);
                System.out.println("New no generated is  :  "+ no);
                for (int j=1;j<=n;j++)
                {
                    if((Integer)obj[j-1].m.get(Integer.valueOf(no))>1)
                    {
                        Integer u=Integer.valueOf(no);
                        Integer y=(Integer) obj[j-1].m.get(u);


                        int r=y.intValue();
                        obj[j-1].m.put( u,Integer.valueOf(r-1));
                        cou[j-1]++;

                        if(cou[j-1]==3)
                        {
                            System.out.println("Winner is : "+ obj[j-1].name);
                            e=1;
                            break;
                        }

                    }


                }
                if(e==1)
                    break;


            }
            if(e==0)
                System.out.println("Match Tie");

        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}