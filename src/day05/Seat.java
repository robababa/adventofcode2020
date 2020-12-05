package day05;

public class Seat {
    private String seatCode;

    public static Seat fromString(String s) {
        Seat seat = new Seat();
        seat.seatCode = s;
        return seat;
    }

    public Integer seatNumber() {
        String numberString = this.seatCode.replace('F', '0').replace('B', '1').replace('L', '0').replace('R', '1');
        return Integer.parseInt(numberString, 2);
    }
}
