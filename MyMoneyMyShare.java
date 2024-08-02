import java.util.*;
public class MyMoneyMyShare{
    static class People{
        int share;
        ArrayList<Integer> applesList;
        People(int share){
            this.share = share;
            // applesList = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> apples = new ArrayList<>();
        int totalWeight = 0;
        while(true){
            System.out.println("Enter apple weight in gram (-1 to stop): ");
            int weight = sc.nextInt();
            if(weight == -1)break;

            totalWeight += weight;
            apples.add(weight);
        }
        Collections.sort(apples);

        People Ram = new People(50);
        People Shyam = new People(30);
        People Rahim = new People(20);


        int idleShareOfRam = totalWeight * (Ram.share/100);
        int idleShareOfShyam = totalWeight * (Shyam.share/100);
        int idleShareOfRahim = totalWeight * (Rahim.share/100);

        ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
        helper(0,new ArrayList<>(Arrays.asList(1,2,3)), new ArrayList<>(), subset);
        System.out.println(subset);

        
        
    }

    static void helper(int index, ArrayList<Integer> apples, ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> subsets){
        if(index == apples.size()){
            subsets.add(new ArrayList<>(curr));
            return;
        }

        helper(index+1,apples,curr,subsets);
        curr.add(apples.get(index));
        helper(index+1, apples, curr, subsets);
        curr.remove(curr.size()-1);
    }
}