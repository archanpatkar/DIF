# DIF
### DIF - Dependancy Injection Framework is written in Java with JSON based Configuration for Java

## Example Usage

### Config.json
``` json
{
    "Point1": 
              {
                  "Class":"com.archanpatkar.demo.Point",
                  "Fields":[
                      {"name":"x","medium":"set","type":"int","value":"10"},
                      {"name":"y","medium":"set","type":"int","value":"20"}
                  ]
              },
    "Point2": 
              {
                  "Class":"com.archanpatkar.demo.Point",
                  "Fields":[
                      {"name":"x","medium":"set","type":"int","value":"30"},
                      {"name":"y","medium":"set","type":"int","value":"40"}
                  ]
              },
   "Segment1":
              {
                  "Class":"com.archanpatkar.demo.Segment",
                  "Fields":[
                       {"name":"p1","medium":"set","value":"contains-Point1"},
                       {"name":"p2","medium":"set","value":"contains-Point2"}
                  ]
              }
}
```

### Main.java
```java
 package com.archanpatkar.demo;
 
 import com.archanpatkar.Container.Factory;

 public class Main		
 {		
 		
     public static void main(String[] args) throws Exception		
     {		
         Factory f1 = new Factory("path-to-json\\Config.json");        		
         Segment s1 = (Segment)f1.getInstance("Segment1");		
         System.out.println(s1);		
     }		
 		
 }
 ```
### Point.java
``` java
package com.archanpatkar.demo;

public class Point {

    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

}
```

### Segment.java

``` java
package com.archanpatkar.demo;

public class Segment 
{
    private Point p1;
    private Point p2;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Segment{" + "p1=" + p1 + ", p2=" + p2 + '}';
    }
    
}
```
