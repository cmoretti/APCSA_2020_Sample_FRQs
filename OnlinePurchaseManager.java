import java.util.ArrayList;

public class OnlinePurchaseManager
{

    private ArrayList<Gizmo> purchases;

    // part a
    public int countElectronicsByMaker(String maker) {
        int count = 0;
        for(Gizmo g : purchases) {
            if(g.isElectronic() && maker.equals(g.getMaker()))
                count++;
        }
        return count;
    }

    // part b
    public boolean hasAdjacentEqualPair() {
        Gizmo prev = null;
        for(Gizmo g : purchases) {
            if(prev != null) {
                if(g.equals(prev))
                    return true;
            }
            prev = g;
        }
        return false;
    }

    // part c
    /*
      It is unclear whether "by an individual" means that the 
      individual is a parameter. Since, unlike maker, it is not 
      termed as "given", I will assume not. Thus, the method 
      header is:
      public Gizmo getCheapestGizmoByMaker(String maker)

      This would require the Gizmo class to have a price for each
      instance, likely an intstance variable. A price could be a
      double, or could be stored as a String to avoid floating point
      imprecision, for example: private String price. The
      OnlinePurchaseManager class would need access to this price, so
      the Gizmo class would also need a getter for that price, for
      example the instance method: public String getPrice(), which
      would simply return the value of the instance variable. The
      Gizmo class would also need a way to set the price for an
      instance, perhaps with an extra parameter in the constructor or
      a setter method like: public String setPrice(String newPrice).

     */

    public OnlinePurchaseManager() {
        purchases = new ArrayList<Gizmo>();
    }
    
    private void addPurchase(String m, boolean isE) {
        purchases.add(new Gizmo(m, isE));
    }

    public static void main(String[] args) {
        OnlinePurchaseManager opm = new OnlinePurchaseManager();
        opm.addPurchase("ABC", true);
        opm.addPurchase("ABC", false);
        opm.addPurchase("XYZ", true);
        opm.addPurchase("lmnop", false);
        opm.addPurchase("ABC", true);
        opm.addPurchase("ABC", false);

        System.out.printf("cEBM(ABC)    should be 2: %d\n", opm.countElectronicsByMaker("ABC"));
        System.out.printf("cEBM(lmnop)  should be 0: %d\n", opm.countElectronicsByMaker("lmnop"));
        System.out.printf("cEBM(XYZ)    should be 1: %d\n", opm.countElectronicsByMaker("XYZ"));
        System.out.printf("cEBM(QRP)    should be 0: %d\n", opm.countElectronicsByMaker("QRP"));
    

        System.out.printf("hAEP should be false: %b\n", opm.hasAdjacentEqualPair());
        opm.addPurchase("ABC", false);
        System.out.printf("hAEP should be true: %b\n", opm.hasAdjacentEqualPair());
    }
    
}
