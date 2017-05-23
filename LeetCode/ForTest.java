/**
 * Created by liuyang on 17/3/8.
 */
public class ForTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==4){
                    i=5;
                    break;
                }
                System.out.println("i:" + i);
                System.out.println("j:" + j);
            }
        }
    }
}
