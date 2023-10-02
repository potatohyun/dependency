package assignment.first.container;

import assignment.first.ioC.Injection;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Injection ioc = new Injection();

        //Water와 Flower를 bean으로 등록
        ioc.registerBean(new Water());
        ioc.registerBean(new Flower());

        Flower flower = (Flower) ioc.getBean(Flower.class);

        //의존성 주입 전의 데이터
        flower.getFlowerColorInfo();

        // 의존성 주입 후 데이터
        ioc.injectDependencies();
        flower.getFlowerColorInfo();
    }
}
