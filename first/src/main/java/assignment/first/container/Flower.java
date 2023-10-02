package assignment.first.container;

import assignment.first.annotation.Dependency;

public class Flower {
    @Dependency
    private Water water;

    public void getFlowerColorInfo() {
        if (water != null) {
            water.test();
        } else {
            System.out.println("there is no water");
        }
    }
}
