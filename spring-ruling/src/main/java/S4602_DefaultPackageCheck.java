import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * S4602 - True Positive: @ComponentScan in default package (no package declaration).
 *
 * A class in the default package with @ComponentScan will scan ALL packages,
 * which is a performance issue and can lead to unexpected bean registration.
 * SonarJava should flag this.
 */
@Configuration
@ComponentScan // Noncompliant - in default package, scans everything
public class S4602_DefaultPackageCheck {
}
