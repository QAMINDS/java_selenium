package module1.java_basic;

public class towers {
    public static void main(String[] args){
                    // 0  1  2  3  4
        int[] arreglo={1, 5, 3, 7, 2};
        for(int i=1; i< arreglo.length; i++){
            for(int x=1;x<arreglo.length; x++){
              if(arreglo[x] < arreglo[i]){
                    System.out.println(x-i);
                    break;
                }
            }
        }
    }
}
