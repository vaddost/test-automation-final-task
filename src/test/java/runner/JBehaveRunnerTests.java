package runner;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;
import steps.*;

import java.util.List;

@RunWith(JUnitReportingRunner.class)
@UsingEmbedder(metaFilters = {"-skip"})
public class JBehaveRunnerTests extends JUnitStories {

    BeforeAfterSteps beforeAfterSteps = new BeforeAfterSteps();

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.HTML, Format.CONSOLE)
                        .withFailureTrace(true)
                        .withFailureTraceCompression(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), List.of(
                beforeAfterSteps,
                new HomePageSteps(beforeAfterSteps),
                new SearchResultsPageSteps(beforeAfterSteps),
                new ProductDetailsPageSteps(beforeAfterSteps),
                new ProductListingPageSteps(beforeAfterSteps),
                new WishListPageSteps(beforeAfterSteps),
                new SignInPageSteps(beforeAfterSteps)
        ));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(CodeLocations.codeLocationFromPath("src/main/resources")
                , List.of("**/*.story")
                , List.of(""));
    }
}
