package hello.proxy;

import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import hello.proxy.config.v5_autoproxy.AutoProxyConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import({DynamicProxyFilterConfig.class, AppV2Config.class})
//@Import({ProxyFactoryConfigV1.class, AppV2Config.class})
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app")
//@SpringBootApplication(scanBasePackages = "hello.proxy.config")

public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
