//import java.io.*;
//import java.util.*;
//import java.lang.*;
//
//public class Main {
//    enum BuySell {
//        BUY,
//        SELL
//    }
//
//    static class PnlCalculator {
//        Map<String, Long> instrumentPriceMap = new TreeMap<>();
//        Map<String,Map> instrumentTradeMap = new TreeMap<>();
//        public void processTrade(long tradeId, String instrumentId, BuySell buySell, long price, long volume) {
//            Map<Long,Long> tradeMap = new TreeMap<>();
//            if (instrumentTradeMap.containsKey(instrumentId)){
//                tradeMap =  instrumentTradeMap.get(instrumentId);
//            }else{
//                instrumentTradeMap.put(instrumentId,tradeMap);
//            }
//            Long instrumentPrice = instrumentPriceMap.get(instrumentId);
//            long pnl= 0;
//            if(buySell.equals(BuySell.BUY)){
//                pnl = (instrumentPrice-price)*volume;
//            }else{
//                pnl = (price - instrumentPrice) * volume;
//            }
//            tradeMap.put(tradeId, pnl);
//        }
//
//        public void processPriceUpdate(String instrumentId, long price) {
//            instrumentPriceMap.put(instrumentId, price);
//        }
//
//        // returns the output string to be printed
//        String outputWorstTrade(String instrumentId)
//        {
//            Map<Long,Long> tradeMap = instrumentTradeMap.get(instrumentId);
//            long min = 0;
//            long tradeId = -1;
//            for(long i: tradeMap.keySet()){
//                if (tradeMap.get(i)<min){
//                    min = tradeMap.get(i);
//                    tradeId = i;
//                }
//            }
//            if (min >= 0){
//                return "NO BAD TRADES";
//            }else
//                return String.valueOf(tradeId);
//        }
//    }
//
//    static class Instrucment{
//        private String instrucmentId;
//        private float price;
//        public Instrucment(String id, float price){
//            this.instrucmentId = id;
//            this.price = price;
//        }
//        public String getInstrucmentId(){
//            return this.instrucmentId;
//        }
//        public float getPrice(){
//            return this.price;
//        }
//        public void setInstrucmentId(String id){
//            this.instrucmentId = id;
//        }
//        public void setPrice(float price){
//            this.price = price;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        PnlCalculator calculator = new PnlCalculator();
//
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < n; i++) {
//            String[] query = scanner.nextLine().split(" ");
//            String queryType = query[0];
//
//            if (queryType.equals("TRADE")) {
//                long tradeId = Long.parseLong(query[1]);
//                String instrumentId = query[2];
//                String buySell = query[3];
//                long price = Long.parseLong(query[4]);
//                long volume = Long.parseLong(query[5]);
//
//                if (buySell.equals("BUY")) {
//                    calculator.processTrade(tradeId, instrumentId, BuySell.BUY, price, volume);
//                } else if (buySell.equals("SELL")) {
//                    calculator.processTrade(tradeId, instrumentId, BuySell.SELL, price, volume);
//                } else {
//                    System.out.println("Malformed input!");
//                    System.exit(-1);
//                }
//            } else if (queryType.equals("PRICE")) {
//                String instrumentId = query[1];
//                long price = Long.parseLong(query[2]);
//                calculator.processPriceUpdate(instrumentId, price);
//            } else if (queryType.equals("WORST_TRADE")) {
//                String instrumentId = query[1];
//                String output = calculator.outputWorstTrade(instrumentId);
//                System.out.println(output);
//            } else {
//                System.out.println("Malformed input!");
//                System.exit(-1);
//            }
//        }
//    }
//}
