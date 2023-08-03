class Solution {
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};
        
        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            }
            else if (num >= 500) {
                if (num >= 900) {
                    sb.append("CM");
                    num -= 900;
                } else {
                    sb.append("D");
                    num -= 500;
                }
                
            }
            else if (num >= 100) {
                if (num >= 400) {
                    sb.append("CD");
                    num -= 400;
                } else {
                    sb.append("C");
                    num -= 100;
                }
                
            }
            else if (num >= 50) {
                if (num >= 90) {
                    sb.append("XC");
                    num -= 90;
                } else {
                    sb.append("L");
                    num -= 50;
                }
                
            }
            else if (num >= 10) {
                if (num >= 40) {
                    sb.append("XL");
                    num -= 40;
                } else {
                    sb.append("X");
                    num -= 10;
                }
            }
            else if (num >= 5) {
                if (num >= 9) {
                    sb.append("IX");
                    num -= 9;
                } else {
                    sb.append("V");
                    num -= 5;
                }
            }
            else if (num >= 1) {
                if (num >= 4) {
                    sb.append("IV");
                    num -= 4;
                } else {
                    sb.append("I");
                    num -= 1;
                }

            }
        }
        
        return sb.toString();
    }
}