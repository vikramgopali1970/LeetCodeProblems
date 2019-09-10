package LeetProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InvalidTransactions {
        public class Transaction{
            String name;
            String city;
            int amt;
            int time;

            public Transaction(String name, int time, int amt, String city){
                this.name = name;
                this.city = city;
                this.amt = amt;
                this.time = time;
            }

            public String toString(){
                return this.name+","+this.time+","+this.amt+","+this.city;
            }
        }

        public List<String> invalidTransactions(String[] transactions) {
            Transaction[] txn = new Transaction[transactions.length];
            for(int i=0;i<txn.length;i++){
                String[] t = transactions[i].split(",");
                txn[i] = new Transaction(t[0],Integer.parseInt(t[1]), Integer.parseInt(t[2]), t[3]);
            }
            Arrays.sort(txn, new Comparator<Transaction>(){
                public int compare(Transaction t1, Transaction t2){
                    return t1.name.compareTo(t2.name);
                }
            });
            List<String> res = new ArrayList<String>();
            for(int i=0;i<txn.length-1;i++){
                System.out.println(i);
                System.out.println(txn[i]+" "+txn[i+1]);
                if(txn[i].time + 60 > txn[i+1].time && txn[i].name.equals(txn[i+1].name) && !txn[i].city.equals(txn[i+1].city)){
                    res.add(txn[i].toString());
                    res.add(txn[i+1].toString());
                    System.out.println(i);
                    i++;
                }else if(txn[i].amt > 1000){
                    res.add(txn[i].toString());
                }
                System.out.println(i);
            }
            System.out.println(txn[txn.length-1].amt);
            if(txn[txn.length-1].amt > 1000){
                res.add(txn[txn.length-1].toString());
            }
            return res;
        }
}
