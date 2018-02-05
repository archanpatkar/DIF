# DIF
### DIF - Dependancy Injection Framework is written in Java with JSON based Configuration

## Configuration Example

### Main.java
```java
  public class Main		
 {		
 		
     public static void main(String[] args) throws Exception		
     {		
         Factory f1 = new Factory("path-to-json//Config.json");        		
         Segment s1 = (Segment)f1.getInstance("Segment1");		
         System.out.println(s1);		
     }		
 		
 }
 ```

### Config.json
``` json
{
    "Point1": 
              {
                  "Class":"container.Point",
                  "Fields":[
                      {"name":"x","medium":"set","type":"int","value":"10"},
                      {"name":"y","medium":"set","type":"int","value":"20"}
                  ]
              },
    "Point2": 
              {
                  "Class":"container.Point",
                  "Fields":[
                      {"name":"x","medium":"set","type":"int","value":"30"},
                      {"name":"y","medium":"set","type":"int","value":"40"}
                  ]
              },
   "Segment1":
              {
                  "Class":"container.Segment",
                  "Fields":[
                       {"name":"p1","medium":"set","value":"contains-Point1"},
                       {"name":"p2","medium":"set","value":"contains-Point2"}
                 ]
              }
}
```
