package webapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration

@SpringBootApplication
@EnableAutoConfiguration
// This class must not be final or Spring Boot is not happy.
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}