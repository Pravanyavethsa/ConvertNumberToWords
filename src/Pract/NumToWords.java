package Pract;

public class NumToWords {
    private static final String[] ones={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static final String[] teens={"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static final String[] tens={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public static String convertLessThanThousand(int num){
        if(num==0){
            return "";
        } else if(num<10) {
            return ones[num];
        }else if(num<20){
            return teens[num-10];
        }else{
            return tens[num/10]+" "+ones[num%10];
        }
    }
    public static void convertNumberToWords(double number){
        int rupees = (int) number;
        int paise =(int)((number - rupees)*100);
        String rupeesWords = "";
        String paiseWords = "";
        //convert rupees to words
        if(rupees > 0){
            if(rupees >= 1000){
                rupeesWords+= ones[rupees/1000]+" Thousand ";
                rupees%= 1000;
            }
            if(rupees>=100){
                rupeesWords+= ones[rupees/100]+" Hundred ";
                rupees%=100;
            }
            rupeesWords+=convertLessThanThousand(rupees);
        }
        //convert paise to words
        if(paise>0){
            paiseWords="and"+convertLessThanThousand(paise)+" Paise ";
        }
        System.out.println("Rs"+ rupeesWords + paiseWords);
    }

    public static void main(String[] args) {
        double number=37548760.75;
        convertNumberToWords(number);
    }
}
