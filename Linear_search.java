import java.util.*;

class Linear_search{
    public static void main(String args[]){
        System.out.println("Linear_search :");
        int a[]={10,20,40,50};
        int key=50;
        for(int i=0;i < a.length; i++){
            if(a[i]==key){
                System.out.println("The index value is:"+i);
            }
        }
    }
}
