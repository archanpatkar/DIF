package container;


public class Main
{

    public static void main(String[] args)
    throws Exception
    {
        Factory f1 = new Factory("Y:\\Projects\\Container\\src\\container\\LoadeeFile.json");        
        Segment s1 = (Segment)f1.getInstance("Segment1");
        //Invoking Getter method
        System.out.println(s1);
    }

}
