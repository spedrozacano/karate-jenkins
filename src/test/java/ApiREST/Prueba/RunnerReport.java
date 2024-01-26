package ApiREST.Prueba;

import ApiREST.Util.reportUtil;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunnerReport {
    final static Logger looger = LoggerFactory.getLogger(RunnerReport.class);

    @Test
     void testSample() {
        looger.info("Ejecutando nuestra prueba de API");
        Results results =
                Runner.path("classpath:ApiREST/Prueba")
                        .tags("@Register")
                        .outputCucumberJson(true)
                        .parallel(2);
        reportUtil.generateCucumberReport(results.getReportDir());
       // assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}



