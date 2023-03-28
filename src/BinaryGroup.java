public class BinaryGroup {
    protected String species;
    protected String value;
    public BinaryGroup(){
        species="";
        value="-";
    }

    public BinaryGroup(String spe,String val){
        species=spe;
        value=val;
    }

    @Override
    public String toString() {
        return  "("+species+","+value+")";
    }
}
