package edu.umb.cs681.hw10;

public class Test {
	public static void main(String[] args) {
        Position p1 = new Position(35.23454, -21, 64.905);
        Position p2 = new Position(97.48, 35.17, 24.970605);
        Position p3 = new Position(-1.6, 12.567, 10.865);

        System.out.println(p2.equals(p3));

        
        System.out.println(p1.changeLat(50.38942));
        System.out.println(p1.changeLon(-90.35522));
        System.out.println(p1.changeAlt(100));
    }
}
