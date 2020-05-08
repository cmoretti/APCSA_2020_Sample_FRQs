public class Gizmo
{
    private String maker;
    private boolean isE;

    public Gizmo(String m, boolean e) {
        maker = m;
        isE = e;
    }
    
    public String getMaker() {
        return maker;
    }

    public boolean isElectronic() {
        return isE;
    }

    public String toString() {
        return maker+"--"+isE;
    }
    public boolean equals(Object other) {
        return this.toString().equals(other.toString());
    }
}
