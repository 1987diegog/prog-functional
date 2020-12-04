package com.demente.ideas.app.chainer;

public class ChainerExample {

    public static void main(String[] args) {
        MyChainer chainer = new MyChainer();
        StringBuilder name = new StringBuilder();
        name.append("Diego");
        chainer.bienvenido().separador(name).adios();
    }
}
