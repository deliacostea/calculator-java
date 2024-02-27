package org.example.Model;

public class Monom {

   private double coef;
   private int grad;

    public double getCoef() {
        return coef;
    }

    public int getGrad() {
        return grad;
    }

    public Monom(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }
    public Monom multipli(Monom m1)
    {
        Monom m2=new Monom(this.grad+m1.getGrad(), this.coef*m1.getCoef());
        return m2;

    }
    public Monom divi(Monom m1)
    {
        Monom m2=new Monom(this.grad-m1.getGrad(), this.coef/(double)m1.getCoef());
        return m2;

    }
    public Monom derivare()
    {
        Monom m2=new Monom(this.grad-1,this.grad*this.coef);
        return m2;
    }

    public Monom integrare()
    {
        Monom m2=new Monom(this.grad+1,this.coef/(this.grad+1));
        return m2;
    }

}
