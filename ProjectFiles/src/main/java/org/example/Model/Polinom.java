package org.example.Model;

import org.example.Model.Monom;

import java.util.TreeMap;

public class Polinom {
  private  TreeMap<Integer, Monom> poli=new TreeMap<Integer, Monom>();

    public Polinom() {
    }

    public TreeMap<Integer, Monom> getPoli() {
        return poli;
    }
    public int returnGrad()
    {
       return poli.lastEntry().getKey();
    }

    public Monom returnGradMonom()
    {
        return poli.lastEntry().getValue();
    }
    public void addMonom(Monom m1)
    {
        int gradM1=m1.getGrad();
        double coefM1=m1.getCoef();
        if(poli.containsKey(gradM1))//daca contine monom de gradu respectiv
        {
            poli.get(gradM1).setCoef(poli.get(gradM1).getCoef()+coefM1);
        }
        else
        {
            poli.put(gradM1,new Monom(m1.getGrad(),m1.getCoef()));
        }
        if(poli.get(gradM1).getCoef()==0)
            poli.remove(gradM1);
    }

    public String toString()
    {
        String s1="";
        for (Monom m1:poli.values())
        {
            if(m1.getCoef()<0)
               s1=(m1.getCoef() + "x^" + m1.getGrad())+s1;
            else
                s1=("+" + m1.getCoef() + "x^" + m1.getGrad())+s1;

        }
        return s1;
    }
}
