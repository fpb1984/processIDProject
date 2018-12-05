import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {		
    	RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();

    	String jvmName = runtimeBean.getName();
		System.out.println("JVM Name = " + jvmName);
		long pid = Long.valueOf(jvmName.split("@")[0]);
        return "JVM PID  = " + pid;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
