package StringsStringBuilderStringBuffer;

public class PerformanceTest {
    public static void main(String[] args) {
        //FOR CHECKING PERFORMANCE

        long totalSbfTime=0, totalStringTime=0, totalSbTime = 0 ;
        for (int j = 0; j < 10; j++) {
            long startTime, endTime;
            //Using String
            startTime = System.nanoTime();
            String str1 = "Java";
            for (int i = 0; i < 100000; i++) {
                str1 += "programming";
            }
            endTime = System.nanoTime();
            System.out.println("String Time: " + (endTime - startTime) + "ms");
            totalStringTime += (endTime - startTime);

            //Using StringBuilder
            startTime = System. nanoTime();
            StringBuilder stringBuilder = new StringBuilder ("Java");
            for (int i = 0; i < 100000; i++) {
                stringBuilder.append ("programming");
            }
            endTime = System.nanoTime();
            System.out.println("StringBuilder Time: "+(endTime-startTime)+"ms");
            totalSbTime +=(endTime-startTime);

            //Using StringBuffer
            startTime = System. nanoTime();
            StringBuffer stringBuffer = new StringBuffer ("Java");
            for (int i = 0; i < 100000; i++) {
                stringBuffer.append("programming");
            }
            endTime = System.nanoTime();
            System.out.println("StringBuffer Time: "+(endTime-startTime)+"ms");
            totalSbfTime +=(endTime-startTime);
        }

        System.out.println("Avg String Time"+ totalStringTime/10+"ns");
        System.out.println("Avg StringBuilder Time"+ totalSbTime/10+"ns");
        System.out.println("Avg StringBuffer Time"+ totalSbfTime/10+"ns");

        //bcoz of caching StringBuilder may take more time hence take average run test 10 times and see the time
    }
}
