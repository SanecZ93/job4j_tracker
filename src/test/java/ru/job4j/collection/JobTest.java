package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> nameAsc = new JobAscByName();
        int rsl = nameAsc.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> nameAsc = new JobDescByName();
        int rsl = nameAsc.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> nameAsc = new JobAscByPriority();
        int rsl = nameAsc.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> nameAsc = new JobDescByPriority();
        int rsl = nameAsc.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}