package com.demente.ideas.app.chainer;

/**
 * @author 1987Diegog
 */
public class MyChainer {

    public MyChainer bienvenido() {
        System.out.println("bienvenido ");
        return this;
    }

    public MyChainer adios() {
        System.out.println("chau chau ");
        return this;
    }

    public MyChainer separador(StringBuilder text) {
        text.append(" - ");
        System.out.println(text);
        return this;
    }
}
