package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(),"Desert");
        assertEquals(testJob.getPositionType().getValue(),"Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("name",
                new Employer("employer"),
                new Location("location"),
                new PositionType("positionType"),
                new CoreCompetency("coreCompetency"));
        Job job2 = new Job("name",
                new Employer("employer"),
                new Location("location"),
                new PositionType("positionType"),
                new CoreCompetency("coreCompetency"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job();

        char firstChar = testJob.toString().charAt(0);
        char secondChar = testJob.toString().charAt(1);

        assertEquals('\n', firstChar);
        assertEquals('\n', secondChar);
        assertEquals(testJob.toString().endsWith("\n\n"), true);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("name",
                new Employer("employer"),
                new Location("location"),
                new PositionType("positionType"),
                new CoreCompetency("coreCompetency"));
        String str = "\n" +
                "ID: " + testJob.getId() + "\n" +
                "Name: " + testJob.getName() + "\n" +
                "Employer: " + testJob.getEmployer() + "\n" +
                "Location: " + testJob.getLocation() + "\n" +
                "Position Type: " + testJob.getPositionType() + "\n" +
                "Core Competency: " + testJob.getCoreCompetency() +
                "\n";

        assertEquals(testJob.toString(), str);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job emptyJob = new Job();
        Job incompleteJob = new Job("name",
                new Employer("employer"),
                new Location(),
                new PositionType("positionType"),
                new CoreCompetency("coreCompetency"));
        String str = "\n" +
                "ID: " + incompleteJob.getId() + "\n" +
                "Name: " + incompleteJob.getName() + "\n" +
                "Employer: " + incompleteJob.getEmployer() + "\n" +
                "Location: Data not available"  + "\n" +
                "Position Type: " + incompleteJob.getPositionType() + "\n" +
                "Core Competency: " + incompleteJob.getCoreCompetency() +
                "\n";

        assertEquals(emptyJob.toString(), "\n\nOOPS! This job does not seem to exist.\n\n");
        assertEquals(incompleteJob.toString(),str);
    }
}
