public class KMP {

    public static String Text="abababababca123rtdt";
    public static String pattern="abababca";
    public static int[] PMT=new int[pattern.length()];
    public static void main(String[] args) {
        System.out.println("KMP Algorithm");

        PMT=pmt(pattern);

        int a=kmp(Text,pattern);
        System.out.println(a);
    }

    public static int kmp(String Text,String pattern){
        int i=0;
        int j=0;
        while (i<Text.length() && j< pattern.length()){

            if(Text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                j=PMT[j-1];
            }
        }

        if(j==pattern.length()){
            return i-j;
        }else {
            return -1;
        }
    }
    public static int[] pmt(String pattern){

        int length=pattern.length();
        int[] pmt=new int[length];
        pmt[0]=0;
        int i=0,j=1;
        while (j<length){
            if(pattern.charAt(i) == pattern.charAt(j)){
                pmt[j]=pmt[j-1]+1;
                i++;
                j++;
            }else{
                pmt[j]=0;
                i=0;
                j++;
            }
        }
        return pmt;
    }
}
