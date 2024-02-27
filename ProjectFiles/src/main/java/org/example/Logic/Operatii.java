package org.example.Logic;

import org.example.Model.Monom;
import org.example.Model.Polinom;

public class Operatii {

   public static Polinom add_Polinoame(Polinom p1, Polinom p2)
    {
        Polinom p3;
        p3=p1;
        for (Monom m1:p2.getPoli().values())
              { p3.addMonom(m1);

        }
        return p3;


    }
    public static Polinom sub_Polinoame(Polinom p1, Polinom p2)
    {
        Polinom p3;
        p3=p1;
        for (Monom m1:p2.getPoli().values())
        {
            Monom scd =new Monom(m1.getGrad(),-m1.getCoef());
            p3.addMonom(scd);

        }
        return p3;


    }

    public static Polinom multipli_Polinoame(Polinom p1, Polinom p2)
    {
        Polinom p3=new Polinom();
        for (Monom m1:p1.getPoli().values())
        {
            for (Monom m2:p2.getPoli().values())
            {
                Monom m3 =m1.multipli(m2);
                p3.addMonom(m3);

            }


        }
        return p3;
    }
    public static Polinom[] divi_Polinoame(Polinom p1, Polinom p2)
    {
        //n e p1
        //d e p2
        Polinom[] rez=new Polinom[2];
        Polinom q =new Polinom();
        Polinom r =new Polinom();
        if(!p2.getPoli().isEmpty())
        {
           q =new Polinom();
           r =p1;
            while(!r.getPoli().isEmpty() && r.returnGrad()>= p2.returnGrad())
            {
                Monom t = r.returnGradMonom().divi(p2.returnGradMonom());
                q.addMonom(t);
                Polinom d1 =p2;
                Polinom t1=new Polinom();
                Monom t2=new Monom(t.getGrad(),-t.getCoef());
                t1.addMonom(t2);
                r=add_Polinoame(r,multipli_Polinoame(t1,d1));
            }
        }
        rez[0]=q;
        rez[1]=r;
        return rez;
    }
    public static Polinom deriv(Polinom p1)
    {
        Polinom p2=new Polinom();
        for (Monom m1:p1.getPoli().values())
        {
            p2.addMonom(m1.derivare());

        }
        return p2;
    }
    public static Polinom integ(Polinom p1)
    {
        Polinom p2=new Polinom();
        for (Monom m1:p1.getPoli().values())
        {
            p2.addMonom((m1.integrare()));

        }
        return p2;
    }

}
