package biz.alsheimer.vmcontract;

import biz.alsheimer.vmcontract.VmContractApp;
import biz.alsheimer.vmcontract.config.AsyncSyncConfiguration;
import biz.alsheimer.vmcontract.config.EmbeddedElasticsearch;
import biz.alsheimer.vmcontract.config.EmbeddedKafka;
import biz.alsheimer.vmcontract.config.EmbeddedSQL;
import biz.alsheimer.vmcontract.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { VmContractApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
