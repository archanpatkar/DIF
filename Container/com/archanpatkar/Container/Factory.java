package container;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factory {

    private final String Path;

    public String getPath() {
        return Path;
    }

    public Factory(String Path) {
        this.Path = Path;
    }

    private static class Field {

        private String Name;
        private String Medium;
        private String Type;
        private Object Value;

        public Field() {

        }

        public Field(String Name, String Medium, String Type, Object Value) {
            this.Name = Name;
            this.Medium = Medium;
            this.Type = Type;
            this.Value = Value;
        }

        public Field(String Name, String Medium, Object Value) {
            this.Name = Name;
            this.Medium = Medium;
            this.Value = Value;
        }

        public String getName() {
            return Name;
        }

        public String getMedium() {
            return Medium;
        }

        public String getType() {
            return Type;
        }

        public Object getValue() {
            return Value;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setMedium(String Medium) {
            this.Medium = Medium;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

        @Override
        public String toString() {
            return "Field{" + "Name=" + Name + ", Medium=" + Medium + ", Type=" + Type + ", Value=" + Value + '}';
        }

    }

    public Object getInstance(String LogicalName) throws ClassNotFoundException {
        
        try {
            JsonNode node = getObjectConfig(LogicalName, Path);
            Class ObjectClass = Class.forName(node.get("Class").asText());
            System.out.println("Class Name : " + ObjectClass);
            ArrayList<Field> Fields = new ArrayList();
            for (JsonNode j : node.get("Fields")) {
                if (j.get("type") != null) {
                    Fields.add(new Field(j.get("name").asText(), j.get("medium").asText(), j.get("type").asText(), (JsonNode) j.get("value")));
                } else {
                    Fields.add(new Field(j.get("name").asText(), j.get("medium").asText(), (JsonNode) j.get("value")));
                }
            }
            Object object = ObjectClass.newInstance();
            for (Method method : ObjectClass.getMethods()) {
                for (Field field : Fields) {
                    if (method.getName().equals(field.getMedium() + field.getName().toUpperCase())) {
                        JsonNode n = (JsonNode) field.getValue();
                        if (n.asText().startsWith("contains")) {
                            String[] logicallink = n.asText().split("-");
                            System.out.println(logicallink);
                            Object compose = this.getInstance(logicallink[1]);
                            method.invoke(object, compose.getClass().cast(compose));
                        } else {
                            switch (field.getType()) {
                                case "int":
                                    method.invoke(object, n.asInt());
                                    break;
                                case "long":
                                    method.invoke(object, n.asLong());
                                    break;
                                case "double":
                                    method.invoke(object, n.asDouble());
                                    break;
                                case "boolean":
                                    method.invoke(object, n.asBoolean());
                                    break;
                            }
                        }
                    }
                }
            }
            return object;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    private JsonNode getObjectConfig(String propn, String Path) {
        try {
            return new ObjectMapper().readTree(new FileInputStream(Path)).path(propn);
        } catch (IOException ex) {
            System.out.println("Exception");
        }
        return null;
    }
}
