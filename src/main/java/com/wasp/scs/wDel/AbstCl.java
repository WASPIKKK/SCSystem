package com.wasp.scs.wDel;

public abstract class AbstCl {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class A1 extends AbstCl {


}

class A2 extends AbstCl {

}

class Testing {


    public static void main(String[] args) {
        AbstCl c1 = new A1();
        c1.setId(10);
        AbstCl c2 = new A2();
        c2.setId(30);


    }
}
