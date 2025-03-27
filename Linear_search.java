import java.util.*;

class Linear_search{
    public static void main(String args[]){
        System.out.println("Linear_search :");
        int a[]={10,20,40,50,60,70,80,90,100,234,423,342,234,234};
        int key=90;
        for(int i=0;i < a.length; i++){
            if(a[i]==key){
                System.out.println("The index value is:"+i);
            }
        }
    }
}
