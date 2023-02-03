package spring_1;

class bus{
    int busNum;
    static int MAXclient = 30;
    private int client;
    private int cost;
    private int speed;
    private int refuelingAmount;
    private static int count =0;
    boolean state ;

    public bus(){
        this.refuelingAmount = 100;
        this.speed = 0;
        count++;
        state = true;
        raceStart();
    }

    public static int count() {
        return count;
    }

    void raceStart(){
        System.out.println("운행");
    }

    void raceEnd(){
        System.out.println("차고 지행");
    }

    public void setOil(int refuelingAmount){
        this.refuelingAmount += refuelingAmount;
        if(this.refuelingAmount < 10){
            System.out.println("주유가 필요합니다");
        }
        getOil();
    }

    public void getOil(){
        System.out.println("주유량 = "+ this.refuelingAmount);
    }



    void speedChange(bus bus1,int speed){
        if(refuelingAmount >= 10) {
            bus1.speed += speed;
            System.out.println("속도증감소"+speed);
            System.out.println("현재속도"+bus1.speed);
        }else{
            System.out.print("주유량을 확인해주세여");
        }
    }

    void stateChange(bus bus1){
        bus1.state = !state;
        if(bus1.state == true) {
            raceStart();
        }else{
            raceEnd();
            if (refuelingAmount < 10){
                System.out.println("주유가 필요합니다");
            }
        }
    }

    void clientride(bus bus1,int clients){
        if(bus1.client + clients > 30){
            System.out.println("최대 승객 수가 초과 하였습니다");
        }
        else {
            bus1.client += clients;
            int i = MAXclient - client;
            bus1.cost = 1000 * clients;
            System.out.println("탑승 승객 수 = " + clients);
            System.out.println("잔여 승객 수 = " + i);
            System.out.println("요금확인 =" + bus1.cost);
            bus1.cost = 0;

        }
    }
}

public class Spring_1_1 {
    public static void main(String[] args){
        bus bus1 = new bus();
        bus1.raceStart();
        System.out.println( bus.count()+"번 버스객체 만들어짐");
        bus bus2 = new bus();
        System.out.println( bus.count()+"번 버스객체 만들어짐");
        bus1.clientride(bus1,2);
        bus1.clientride(bus1,3);
        bus1.setOil(-50);
        bus1.stateChange(bus1);
        bus1.setOil(10);
        bus1.stateChange(bus1);
        bus1.clientride(bus1,45);
        bus1.clientride(bus1,5);
        bus1.setOil(-55);
    }

}