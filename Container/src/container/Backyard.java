package container;

//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//import org.apache.commons.lang3.ClassUtils;

public class Backyard {
    //     
//    public  Object getInstance(String Name) throws InvocationTargetException {
//        try {
//            JsonNode vobj = getPJson(Name,Path);
//            System.out.println("Getting JSON");
//            //System.out.println(vobj);
//            Class _C_ = Class.forName(vobj.get("Class").asText());
//            System.out.println("Class Name :" + _C_.getName());
//            ArrayList <Field>FieldsList = getFields(vobj);
//            //boolean PrioField = getPrioOfIniFields(FieldsList);
////            System.out.println("Before Creation " + PrioField);
////            if(PrioField == true)
////            {
////                Class para[] = new Class[FieldsList.size()];
////                int counter = 0;
////                for(Field f : FieldsList){
////                    para[counter] = ClassUtils.getClass(getWrapped(f.getType())).;
////                    counter++;
////                }
////                counter = 0;
////                Object obj [] = new Object[FieldsList.size()];
////                for(Field f : FieldsList){
////                    try {
////                        obj[counter] = Class.forName(getWrapped(f.getType())).getConstructor(String.class).newInstance(f.getValue());
////                    } catch (NoSuchMethodException ex) {
////                        Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                    } catch (InstantiationException ex) {
////                        Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                    } catch (IllegalAccessException ex) {
////                        Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                    } catch (IllegalArgumentException ex) {
////                        Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                    } catch (InvocationTargetException ex) {
////                        Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                    }
////                    counter++;d
////                }
////                try 
////                {
////                    return _C_.cast(_C_.getConstructor(para).newInstance(obj));
////                } catch (NoSuchMethodException ex) {
////                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (SecurityException ex) {
////                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (InstantiationException ex) {
////                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (IllegalAccessException ex) {
////                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (IllegalArgumentException ex) {
////                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (InvocationTargetException ex) {
////                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }else
////            {
//               for(Field f : FieldsList)
//               {
//                   try {
//                       Object temp = _C_.newInstance();
//                       for(Method m : _C_.getMethods())
//                       {
//                          if(m.getName() == f.getMedium()+f.getName().toUpperCase())
//                          {
//                              System.out.println(m.getParameters()[0].getParameterizedType().getTypeName());
//                              m.invoke(temp,(Integer)f.getValue().intValue());
//                          }
//                       }
//                       //_C_.getMethod(f.getMedium()+f.getName().toUpperCase(),).invoke(temp,Class.forName(getWrapped(f.getType())).getConstructor(String.class).newInstance(f.getValue()));
//                       return _C_.cast(temp);
//                   } catch (InstantiationException ex) {
//                       Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//                   } catch (IllegalAccessException ex) {
//                       Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//                   } catch (SecurityException ex) {
//                       Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//                   } catch (IllegalArgumentException ex) {
//                       Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//                   }
//               }
//            //}
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    private String getWrapped(String prim){
//        System.out.println("In getWrapped");
//        
//        System.out.println("Leaving getWrapped ");
//        switch(prim){
//            case "int" : return "java.lang.Integer";
//            case "float" : return "java.lang.Float";
//            default:return null;
//        }
//    }
//    
//    private  ArrayList<Field> getFields(JsonNode vobj){
//        System.out.println("Entering getFields");
//        ArrayList FList = new ArrayList<Field>();
//        //Arrays.asList(vobj.get("Fields")).forEach((e)->FList.add(new Field(e.get("name").asText(),e.get("medium").asText(),e.get("type").asText(),e.get("value").asText())));
//        for(JsonNode jn : vobj.get("Fields"))
//        {
//            try {
//                Field F = new Field(jn.get("name").asText(),jn.get("medium").asText(),getWrapped(jn.get("type").asText()), (Integer) Class.forName(getWrapped(jn.get("type").asText())).getConstructor(String.class).newInstance(jn.get("value").asText()));
//                FList.add(F);
//                System.out.println(jn);
//                System.out.println("F : " + F);
//            } catch (NoSuchMethodException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SecurityException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InstantiationException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalArgumentException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InvocationTargetException ex) {
//                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        System.out.println("Leaving getFields");
//        return FList;
//    }
//    
////    private boolean getPrioOfIniFields(ArrayList <Field> FL)
////    {
////        System.out.println("in Prio func");
////        ArrayList <Field> FLi = new ArrayList<>(FL);
////        boolean CorNot = false;
////        for(Field f : FLi)
////        {
////            if(f.getMedium().contains("con"))
////            {
////                System.out.println("in con if condition");
////                CorNot = true;
////            }
////        }
////        System.out.println("Leaving Prio func");
////        if(CorNot == true)
////        {
////            return true;
////        }
////        return CorNot;
////        
////    }
}
