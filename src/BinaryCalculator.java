import static java.lang.Math.abs;

public class BinaryCalculator {
    public static String calculate(String n1, String n2, String o) {

        Integer vn1, vn2;
        vn1 = BinToDec(n1);
        vn2 = BinToDec(n2);
        System.out.println("n1= " + n1);
        System.out.println("n2= " + n2);
        System.out.println("vn1= " + vn1);
        System.out.println("vn2= " + vn2);
        if (o == "add") return DecToBin(vn1 + vn2);
        if (o == "subtract") return ((vn1 < vn2) ? "-" : "") + DecToBin(abs(vn1 - vn2));
        if (o == "multiply") return DecToBin(vn1 * vn2);
        if (vn2 != 0) {
            if (o == "divide") return DecToBin(vn1 / vn2);
        }
        return "-1";
    }

    private static Integer BinToDec(String binVal) {
        //instead of : int answer = Integer.parseInt(binVal, 2);
        int weight = 1, answer = 0;
        for (int i = 0; i < binVal.length(); i++) {
            answer += (binVal.charAt(binVal.length() - 1 - i) - '0') * weight;
            weight *= 2;
        }
        return answer;
    }

    private static String DecToBin(Integer decVal) {
        //instead of : answer = Integer.toBinaryString(decVal);
        String answer = "";
        while (decVal > 0) {
            answer = decVal % 2 + answer;
            decVal /= 2;
        }
        return (answer == "") ? "0" : answer;
    }
}