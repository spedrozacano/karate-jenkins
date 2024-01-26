import com.intuit.karate.junit5.Karate;

public class karaterunnerSOAP {

    @Karate.Test
    Karate testSample() {
        return Karate.run("classpath:ApiSOAP/testSOAP.feature");

    }



}