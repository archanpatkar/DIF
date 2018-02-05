# DIF
### DIF - Dependancy Injection Framework is written in Java with JSON based Configuration

## Configuration Example

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
