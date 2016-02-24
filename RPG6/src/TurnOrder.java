

import java.util.ArrayList;

public class TurnOrder {
    public static void main(String[] arg){
        ArrayList<Unit> Party = new ArrayList<Unit>();
        Party.add(new Unit("Mickey",55));
        Party.add(new Unit("Sora",43));
        Party.add(new Unit("Goofy",34));
        Party.add(new Unit("Donald",22));
        
        int[] Order = new int [Party.size()];

        for(int a = 0; a<Party.size()*25; a++){
        //TODO change to while loop with a boolean condition 
        //indicating battle is still occurring
        System.out.println("Turn Number "+(a+1));
        System.out.println("Player "+currentPlayer(Order,Party).getName());
        System.out.println("-------");
        }
    }
    
    public static Unit currentPlayer(int[] Order, ArrayList<Unit> Party){
        int Max = 100;
        int Fastest = 0;
        int Index = 0;
        Unit Current = null;

        int i;
        while(Current==null){
            i = 0;
            while(i<Order.length){
                Order[i] = Order[i] + (int)Party.get(i).getRechargeRate();
                if(Order[i] >= Max && Order[i] > Fastest){
                    Index = i;
                    Fastest = Order[Index];
                    Current = Party.get(Index);
                }
                i++;
            }
        }
//        for(int idx = 0;idx<Order.length;idx++){
//            System.out.println(Party.get(idx).getName()+" "+Order[idx]);
//        }
        Order[Index] = 0;
        return Current;
    }
}
